var cfMoneyRecord_grid = null;
var cfMoneyRecord_toolbar = {
	items : [ {
		line : true
	}, {
		text : "增加",
		click : cfMoneyRecord_add,
		icon : "add"
	}, {
		line : true
	} ]
};

$(function() {
	var g = {
		gridid : "crowdfunding_cfMoneyRecord_grid",
		condition : "cfMoneyRecordCondition",
		url : basePath+"admin/crowdfunding/cfMoneyRecord!data.action",
		formid : "crowdfunding_cfMoneyRecord_form",
		toolbar : cfMoneyRecord_toolbar,
		checkbox : false,
		columns : [
				{
					display : "操作",
					name : "id",
					render : function(item) {
						var html = "<a href='javascript:;' onclick='cfMoneyRecord_delete(\""
								+ item.id
								+ "\")' class='linkbutton'>删除</a>";
						html += "<a href='javascript:;' onclick='cfMoneyRecord_edit(\""
								+ item.id
								+ "\")' class='linkbutton'>修改</a>";
						return html;
					}
				},
				// columns start
				{
					display : "userId",
					name : "userId"
				},
				{
					display : "recordKind",
					name : "recordKind"
				},
				{
					display : "recordState",
					name : "recordState"
				},
				{
					display : "description",
					name : "description"
				},
				{
					display : "createTime",
					name : "createTime"
				},
		]
	};
	cfMoneyRecord_grid = showGrid(g);
});

function cfMoneyRecord_search() {
	cfMoneyRecord_grid.loadData();
}

function cfMoneyRecord_delete(id) {
	confirm("删除操作", "确认删除吗？", function() {
		$.getJSON(basePath+"admin/crowdfunding/cfMoneyRecord!delete.action?cfMoneyRecord.id=" + id,function(json) {
			if (json.success) {
				cfMoneyRecord_grid.loadData();
			}else{
				alert(json.message,"error");
			}
		});
	});
}

function cfMoneyRecord_add() {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_cfMoneyRecord_add_window",
		url : basePath+"admin/crowdfunding/cfMoneyRecord!toAdd.action",
		onok : function(item, dialog){
			gg("crowdfunding_cfMoneyRecord_add_window").contentWindow.cfMoneyRecord_add_submit(dialog);
		}
	});
}

function cfMoneyRecord_edit(id) {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_cfMoneyRecord_edit_window",
		url : basePath+"admin/crowdfunding/cfMoneyRecord!toEdit.action?cfMoneyRecord.id="+id,
		onok : function(item, dialog){
			gg("crowdfunding_cfMoneyRecord_edit_window").contentWindow.cfMoneyRecord_edit_submit(dialog);
		}
	});
}
