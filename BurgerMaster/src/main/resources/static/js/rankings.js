$(document).ready(fetchStatsByLevel);
$(document).ready(getHeaders);

/**
 * Gets <i>HTML<i> code for table headers.
 * 
 * @returns <i>HTML</i> code for table headers
 */
function getTableHeaders() {
	return "<tr class='rankingsTr'>" +
		   "<th class='rankingsTh'>Rank</th>" +
		   "<th class='rankingsTh'>Username</th>" +
		   "<th class='rankingsTh'>Level</th>" +
		   "<th class='rankingsTh'>Points</th>" +
		   "</tr>";
}

/**
 * Gets <i>HTML</i> code for table data.
 * 
 * @param data
 *            data which will be included in the table
 * @returns <i>HTML</i> code for table
 */
function getTableData(data) {
	let html = getTableHeaders();
	
	for (let i = 0; i < data.length; i++) {
		let rank = i + 1;
		html +=
			"<tr class='rankingsTr'>" +
				"<td class='rankingsTd'>" + rank + "</td>" +
				"<td class='rankingsTd'>" + data[i].username + "</td>" +
				"<td class='rankingsTd'>" + data[i].level + "</td>" +
				"<td class='rankingsTd'>" + data[i].points + "</td>";
	}
	
	return html;
}

/**
 * Fetches user stats from server in descending order by level.
 */
function fetchStatsByLevel() {
	document.getElementById("levelTab").style.backgroundColor = "rgb(255, 111, 39)";
	document.getElementById("pointsTab").style.backgroundColor = "rgb(255, 58, 0)";
	$.get({
		url: "/stats/sorted/byLevel",
		dataType: "json",
		success: function(data) {
			$("#rankingsBody").html(getTableData(data));
		}
	});
}

/**
 * Fetches user stats from server in descending order by points.
 */
function fetchStatsByPoints() {
	document.getElementById("levelTab").style.backgroundColor = "rgb(255, 58, 0)";
	document.getElementById("pointsTab").style.backgroundColor = "rgb(255, 111, 39)";
	$.get({
		url: "/stats/sorted/byPoints",
		dataType: "json",
		success: function(data) {
			$("#rankingsBody").html(getTableData(data));
		}
	})
}