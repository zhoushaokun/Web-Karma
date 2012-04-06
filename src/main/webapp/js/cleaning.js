/*******************************************************************************
 * Copyright 2012 University of Southern California
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * This code was developed by the Information Integration Group as part 
 * of the Karma project at the Information Sciences Institute of the 
 * University of Southern California.  For more information, publications, 
 * and related projects, please see: http://www.isi.edu/integration
 ******************************************************************************/

function assignHandlersToCleaningPanelObjects() {
    var cleaningPanel = $("div#ColumnCleaningPanel"); 
    
    $("button#cleanColumnButton").click(handleCleanColumnButton);
    $("button#generateCleaningRules",cleaningPanel).click(handleGenerateCleaningRulesButton);
}

function handleCleanColumnButton() {
    var columnHeadingMenu = $("div#columnHeadingDropDownMenu");
    columnHeadingMenu.hide();
    
    // Get the values from the column to be cleaned
    var selectedHNodeId = columnHeadingMenu.data("parentCellId");
    var tdTag = $("td#"+selectedHNodeId);
    var table = tdTag.parents("table.WorksheetTable");
    var lastRow = $("thead tr:last", table);
    var index = $("td", lastRow).index(tdTag);
    var values=[];
    $('tbody>tr>td:nth-child('+(index+1)+')', table).each( function() {
        if($(this).attr("id"))    
            values.push({"nodeId":$(this).attr("id"), "nodeValue": $(this).text()});       
    });
    
    // Create and store a array that stores the user provided examples
    var examples = [];
    columnHeadingMenu.data("cleaningExamples", examples);
    
    // Populate the table of cleaning preview table
    var cleaningTable = $("table#cleaningExamplesTable");
    $("tr.nonHeading", cleaningTable).remove();
    $("tr.radioButtons", cleaningTable).remove();
    
    var initialResultsValues = [];
    
    $.each(values, function(index, val) {
        var tr = $("<tr>")
            .attr("id", val["nodeId"]+"_cl_row")
            .addClass("nonHeading")
            .append($("<td>").text(val["nodeValue"]).attr('id',val['nodeId']+"_origVal"))
            .append($("<td>").addClass("noBorder"));
        
        var res = new Object();
        res[val["nodeId"]] = val["nodeValue"];
        initialResultsValues.push(res);
            
        cleaningTable.append(tr);
    });
    
    populateResultsInCleaningTable(initialResultsValues);
    
    // Add the radio button row
    cleaningTable.append($("<tr>").addClass("radioButtons")
        .append($("<td>").addClass("noBorder"))
        .append($("<td>").addClass("noBorder"))
        .append($("<td>")
            .append($("<input>").attr("type", "radio")
                .attr("name", "cleaningRuleSelect")
                .attr("value", "rule0")
                .prop("checked", true)
        )
    ));
    
    $("div#ColumnCleaningPanel").dialog({title: 'Transform', width: 500,
        height: 500, buttons: { "Cancel": function() { $(this).dialog("close"); },  
            "Generate Rules": handleGenerateCleaningRulesButton,
            "Submit":function() { $(this).dialog("close"); }}});
}

function populateResultsInCleaningTable(data) {
    var examples = $("div#columnHeadingDropDownMenu").data("cleaningExamples", examples);
    var cleaningTable = $("table#cleaningExamplesTable");
    
    // Remove the old results
    $("td.ruleResultsValue", cleaningTable).remove();
    $("tr.radioButtons", cleaningTable).remove();
    
    $.each(data, function(index, ruleResult){
        for(var nodeId in ruleResult) {
            var trTag = $("tr#"+nodeId + "_cl_row");
            if(trTag != null) {
                trTag.append($("<td>").addClass('Rule'+index)
                    .addClass("ruleResultsValue")
                    .append($("<table>").addClass("cleaningExampleDivTable").append($("<tr>")
                        .append($("<td>")
                            .append($("<div>")
                                .data("nodeId", nodeId)
                                .data("originalVal", $("td#" + nodeId +"_origVal",cleaningTable).text())
                                .data("cellValue", ruleResult[nodeId])
                                .addClass("cleanExampleDiv")
                                .text(ruleResult[nodeId])
                                .attr("id",nodeId+"_c"+index)
                                .editable(function(value, settings) {
                                    var editDiv = $(this);
                                    
                                    // Add the revert button
                                    var revertButton = $("<div>").addClass("undoEditButton").button({
                                        icons: {
                                            primary: 'ui-icon-arrowreturnthick-1-w'
                                        },
                                        text: false
                                    }).click(function(){
                                        editDiv.text(editDiv.data("cellValue"));
                                        $(this).parent().remove();
                                        
                                        // Remove the user provided example from the examples JSON object
                                        var delInd = -1;
                                        $.each(examples, function(index2, example){
                                            if(example["nodeId"] == editDiv.data("nodeId"))
                                                delInd = index2; 
                                        });
                                        if(delInd != -1)
                                            examples.splice(delInd, 1);
                                    }).qtip({
                                       content: {
                                          text: 'Undo'
                                       },
                                       style: {
                                          classes: 'ui-tooltip-light ui-tooltip-shadow'
                                       }
                                    });
                                    
                                    // Remove existing button
                                    $("td.noBorder", $(this).parent().parent()).remove();
                                    $(this).parent().parent().append($("<td>").addClass("noBorder").append(revertButton));
                                    
                                    examples.push(
                                        {
                                            "nodeId":$(this).data("nodeId"),
                                            "before": $(this).data("originalVal"),
                                            "after":value
                                        });
                                    return(value);
                                }, { 
                                    type    : 'textarea',
                                    submit  : 'OK',
                                    cancel  : 'Cancel',
                                    width: 140,
                                    onblur: 'ignore',
                                })
                            )
                        )
                    )
                )
            )
            }
        }
    });
    
    // Add radio buttons
    
    
}

function handleGenerateCleaningRulesButton() {
    var columnHeadingMenu = $("div#columnHeadingDropDownMenu");
    var selectedHNodeId = columnHeadingMenu.data("parentCellId");
    var tdTag = $("td#"+selectedHNodeId);
    var vWorksheetId = tdTag.parents("div.Worksheet").attr("id");
    
    var examples = columnHeadingMenu.data("cleaningExamples");
    
    var info = new Object();
    info["vWorksheetId"] = vWorksheetId;
    info["workspaceId"] = $.workspaceGlobalInformation.id;
    info["hNodeId"] = selectedHNodeId;
    info["command"] = "GenerateCleaningRulesCommand";
    info["examples"] = JSON.stringify(examples);
            
    var returned = $.ajax({
        url: "/RequestController", 
        type: "POST",
        data : info,
        dataType : "json",
        complete : 
            function (xhr, textStatus) {
                var json = $.parseJSON(xhr.responseText);
                parse(json);
            },
        error :
            function (xhr, textStatus) {
                $.sticky("Error generating new cleaning rules!");
            }          
    });
}