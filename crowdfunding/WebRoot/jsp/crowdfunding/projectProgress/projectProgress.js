var projectProgress_grid = null;
var projectProgress_toolbar = {
	items : [ {
		line : true
	}, {
		text : "增加",
		click : projectProgress_add,
		icon : "add"
	}, {
		line : true
	} ]
};

$(function() {
	var g = {
		gridid : "crowdfunding_projectProgress_grid",
		condition : "projectProgressCondition",
		url : basePath+"admin/crowdfunding/projectProgress!data.action",
		formid : "crowdfunding_projectProgress_form",
		toolbar : projectProgress_toolbar,
		checkbox : false,
		columns : [
				{
					display : "操作",
					name : "id",
					render : function(item) {
						var html = "<a href='javascript:;' onclick='projectProgress_delete(\""
								+ item.id
								+ "\")' class='linkbutton'>删除</a>";
						html += "<a href='javascript:;' onclick='projectProgress_edit(\""
								+ item.id
								+ "\")' class='linkbutton'>修改</a>";
						return html;
					}
				},
				// columns start
				{
					display : "项目发起人",
					name : "userId"
				},
				{
					display : "项目ID",
					name : "projectId"
				},
				{
					display : "项目名称",
					name : "projectName"
				},
				{
					display : "进度内容",
					name : "progressContent"
				},
				{
					display : "图片",
					name : "progressImage"
				},
				{
					display : "创建时间",
					name : "createTime"
				},
				{
					display : "缩略图",
					name : "progressThumImage"
				},
		]
	};
	projectProgress_grid = showGrid(g);
});

function projectProgress_search() {
	projectProgress_grid.loadData();
}

function projectProgress_delete(id) {
	confirm("删除操作", "确认删除吗？", function() {
		$.getJSON(basePath+"admin/crowdfunding/projectProgress!delete.action?projectProgress.id=" + id,function(json) {
			if (json.success) {
				projectProgress_grid.loadData();
			}else{
				alert(json.message,"error");
			}
		});
	});
}

function projectProgress_add() {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_projectProgress_add_window",
		url : basePath+"admin/crowdfunding/projectProgress!toAdd.action",
		onok : function(item, dialog){
			gg("crowdfunding_projectProgress_add_window").contentWindow.projectProgress_add_submit(dialog);
		}
	});
}

function projectProgress_edit(id) {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_projectProgress_edit_window",
		url : basePath+"admin/crowdfunding/projectProgress!toEdit.action?projectProgress.id="+id,
		onok : function(item, dialog){
			gg("crowdfunding_projectProgress_edit_window").contentWindow.projectProgress_edit_submit(dialog);
		}
	});
}
