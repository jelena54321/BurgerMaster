$(document).ready(fetchMapData);
$(document).ready(getHeaders);

var levels;
var userStats;

function fetchMapData() {
	document.getElementById("mapInfo").style.display = "none";
	
	$.get({
		url: "/levels/asMap",
		dataType: "json",
		success: function(data) {
			levels = data;
			
			let html = "";
			for (let level in data) {
				let levelValue = data[level];
				html +=
					"<area " +
						"shape='circle' " +
						"coords='" + levelValue.x + "," + levelValue.y + ",10' " +
						"onMouseLeave='onLeaveArea()' " +
						"onMouseOver='updateInfo(event, " + levelValue.level + ")'/>";
			}
			
			$("#levels").html(html);
		}
	});
	
	$.get({
		url: "/users/current",
		dataType: "json",
		success: function(user) {
			
			$.get({
				url: "stats/single",
				data: "username=" + user.username,
				headers: {
					"Content-Type": "application/x-www-form-urlencoded"
				},
				dataType: "json",
				success: function(data) {
					userStats = data;
				}
			});
		
		}
	});
}

function updateInfo(event, area) {
	let level = levels[area];
	document.getElementById("mapImage").src = "media/level" + level.level + ".png";
	document.getElementById("levelNameLabel").innerText = level.name;
	document.getElementById("levelLabel").innerText = level.level;
	document.getElementById("availableLabel").innerText = isAvailable(level.level);
	document.getElementById("burgerLabel").innerText = level.burger;
	document.getElementById("levelDescription").innerText = level.description;
	document.getElementById("mapInfo").style.display = "grid";
}

function isAvailable(level) {
	return level <= userStats.level;
}

function onLeaveArea() {
	console.log("here");
	document.getElementById("mapInfo").style.display = "none";
}