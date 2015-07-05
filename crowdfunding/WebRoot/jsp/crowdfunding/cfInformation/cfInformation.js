var cfInformation_grid = null;
var cfInformation_toolbar = {
	items : [ {
		line : true
	}, {
		text : "增加",
		click : cfInformation_add,
		icon : "add"
	}, {
		line : true
	} ]
};

$(function() {
	var g = {
		gridid : "crowdfunding_cfInformation_grid",
		condition : "cfInformationCondition",
		url : basePath+"admin/crowdfunding/cfInformation!data.action",
		formid : "crowdfunding_cfInformation_form",
		toolbar : cfInformation_toolbar,
		checkbox : false,
		columns : [
				{
					display : "操作",
					name : "id",
					render : function(item) {
						var html = "<a href='javascript:;' onclick='cfInformation_delete(\""
								+ item.id
								+ "\")' class='linkbutton'>删除</a>";
						html += "<a href='javascript:;' onclick='cfInformation_edit(\""
								+ item.id
								+ "\")' class='linkbutton'>修改</a>";
						return html;
					}
				},
				// columns start
				{
					display : "sendUserId",
					name : "sendUserId"
				},
				{
					display : "receiveUserId",
					name : "receiveUserId"
				},
				{
					display : "content",
					name : "content"
				},
				{
					display : "createTime",
					name : "createTime"
				},
		]
	};
	cfInformation_grid = showGrid(g);
});

function cfInformation_search() {
	cfInformation_grid.loadData();
}

function cfInformation_delete(id) {
	confirm("删除操作", "确认删除吗？", function() {
		$.getJSON(basePath+"admin/crowdfunding/cfInformation!delete.action?cfInformation.id=" + id,function(json) {
			if (json.success) {
				cfInformation_grid.loadData();
			}else{
				alert(json.message,"error");
			}
		});
	});
}

function cfInformation_add() {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_cfInformation_add_window",
		url : basePath+"admin/crowdfunding/cfInformation!toAdd.action",
		onok : function(item, dialog){
			gg("crowdfunding_cfInformation_add_window").contentWindow.cfInformation_add_submit(dialog);
		}
	});
}

function cfInformation_edit(id) {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_cfInformation_edit_window",
		url : basePath+"admin/crowdfunding/cfInformation!toEdit.action?cfInformation.id="+id,
		onok : function(item, dialog){
			gg("crowdfunding_cfInformation_edit_window").contentWindow.cfInformation_edit_submit(dialog);
		}
	});
}
