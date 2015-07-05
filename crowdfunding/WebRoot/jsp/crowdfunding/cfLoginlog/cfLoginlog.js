var cfLoginlog_grid = null;
var cfLoginlog_toolbar = {
	items : [ {
		line : true
	}, {
		text : "增加",
		click : cfLoginlog_add,
		icon : "add"
	}, {
		line : true
	} ]
};

$(function() {
	var g = {
		gridid : "crowdfunding_cfLoginlog_grid",
		condition : "cfLoginlogCondition",
		url : basePath+"admin/crowdfunding/cfLoginlog!data.action",
		formid : "crowdfunding_cfLoginlog_form",
		toolbar : cfLoginlog_toolbar,
		checkbox : false,
		columns : [
				{
					display : "操作",
					name : "id",
					render : function(item) {
						var html = "<a href='javascript:;' onclick='cfLoginlog_delete(\""
								+ item.id
								+ "\")' class='linkbutton'>删除</a>";
						html += "<a href='javascript:;' onclick='cfLoginlog_edit(\""
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
					display : "content",
					name : "content"
				},
				{
					display : "createTime",
					name : "createTime"
				},
		]
	};
	cfLoginlog_grid = showGrid(g);
});

function cfLoginlog_search() {
	cfLoginlog_grid.loadData();
}

function cfLoginlog_delete(id) {
	confirm("删除操作", "确认删除吗？", function() {
		$.getJSON(basePath+"admin/crowdfunding/cfLoginlog!delete.action?cfLoginlog.id=" + id,function(json) {
			if (json.success) {
				cfLoginlog_grid.loadData();
			}else{
				alert(json.message,"error");
			}
		});
	});
}

function cfLoginlog_add() {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_cfLoginlog_add_window",
		url : basePath+"admin/crowdfunding/cfLoginlog!toAdd.action",
		onok : function(item, dialog){
			gg("crowdfunding_cfLoginlog_add_window").contentWindow.cfLoginlog_add_submit(dialog);
		}
	});
}

function cfLoginlog_edit(id) {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_cfLoginlog_edit_window",
		url : basePath+"admin/crowdfunding/cfLoginlog!toEdit.action?cfLoginlog.id="+id,
		onok : function(item, dialog){
			gg("crowdfunding_cfLoginlog_edit_window").contentWindow.cfLoginlog_edit_submit(dialog);
		}
	});
}
