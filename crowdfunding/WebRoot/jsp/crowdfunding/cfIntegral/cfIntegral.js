var cfIntegral_grid = null;
var cfIntegral_toolbar = {
	items : [ {
		line : true
	}, {
		text : "增加",
		click : cfIntegral_add,
		icon : "add"
	}, {
		line : true
	} ]
};

$(function() {
	var g = {
		gridid : "crowdfunding_cfIntegral_grid",
		condition : "cfIntegralCondition",
		url : basePath+"admin/crowdfunding/cfIntegral!data.action",
		formid : "crowdfunding_cfIntegral_form",
		toolbar : cfIntegral_toolbar,
		checkbox : false,
		columns : [
				{
					display : "操作",
					name : "id",
					render : function(item) {
						var html = "<a href='javascript:;' onclick='cfIntegral_delete(\""
								+ item.id
								+ "\")' class='linkbutton'>删除</a>";
						html += "<a href='javascript:;' onclick='cfIntegral_edit(\""
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
					display : "integralType",
					name : "integralType"
				},
				{
					display : "integralDetail",
					name : "integralDetail"
				},
				{
					display : "integralValue",
					name : "integralValue"
				},
				{
					display : "createTime",
					name : "createTime"
				},
		]
	};
	cfIntegral_grid = showGrid(g);
});

function cfIntegral_search() {
	cfIntegral_grid.loadData();
}

function cfIntegral_delete(id) {
	confirm("删除操作", "确认删除吗？", function() {
		$.getJSON(basePath+"admin/crowdfunding/cfIntegral!delete.action?cfIntegral.id=" + id,function(json) {
			if (json.success) {
				cfIntegral_grid.loadData();
			}else{
				alert(json.message,"error");
			}
		});
	});
}

function cfIntegral_add() {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_cfIntegral_add_window",
		url : basePath+"admin/crowdfunding/cfIntegral!toAdd.action",
		onok : function(item, dialog){
			gg("crowdfunding_cfIntegral_add_window").contentWindow.cfIntegral_add_submit(dialog);
		}
	});
}

function cfIntegral_edit(id) {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_cfIntegral_edit_window",
		url : basePath+"admin/crowdfunding/cfIntegral!toEdit.action?cfIntegral.id="+id,
		onok : function(item, dialog){
			gg("crowdfunding_cfIntegral_edit_window").contentWindow.cfIntegral_edit_submit(dialog);
		}
	});
}
