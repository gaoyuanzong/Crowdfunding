var cfReaddress_grid = null;
var cfReaddress_toolbar = {
	items : [ {
		line : true
	}, {
		text : "增加",
		click : cfReaddress_add,
		icon : "add"
	}, {
		line : true
	} ]
};

$(function() {
	var g = {
		gridid : "crowdfunding_cfReaddress_grid",
		condition : "cfReaddressCondition",
		url : basePath+"admin/crowdfunding/cfReaddress!data.action",
		formid : "crowdfunding_cfReaddress_form",
		toolbar : cfReaddress_toolbar,
		checkbox : false,
		columns : [
				{
					display : "操作",
					name : "id",
					render : function(item) {
						var html = "<a href='javascript:;' onclick='cfReaddress_delete(\""
								+ item.id
								+ "\")' class='linkbutton'>删除</a>";
						html += "<a href='javascript:;' onclick='cfReaddress_edit(\""
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
					display : "receivesName",
					name : "receivesName"
				},
				{
					display : "receivesCity",
					name : "receivesCity"
				},
				{
					display : "receivesDetail",
					name : "receivesDetail"
				},
				{
					display : "receivesCode",
					name : "receivesCode"
				},
				{
					display : "mobile",
					name : "mobile"
				},
				{
					display : "isDefault",
					name : "isDefault"
				},
		]
	};
	cfReaddress_grid = showGrid(g);
});

function cfReaddress_search() {
	cfReaddress_grid.loadData();
}

function cfReaddress_delete(id) {
	confirm("删除操作", "确认删除吗？", function() {
		$.getJSON(basePath+"admin/crowdfunding/cfReaddress!delete.action?cfReaddress.id=" + id,function(json) {
			if (json.success) {
				cfReaddress_grid.loadData();
			}else{
				alert(json.message,"error");
			}
		});
	});
}

function cfReaddress_add() {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_cfReaddress_add_window",
		url : basePath+"admin/crowdfunding/cfReaddress!toAdd.action",
		onok : function(item, dialog){
			gg("crowdfunding_cfReaddress_add_window").contentWindow.cfReaddress_add_submit(dialog);
		}
	});
}

function cfReaddress_edit(id) {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_cfReaddress_edit_window",
		url : basePath+"admin/crowdfunding/cfReaddress!toEdit.action?cfReaddress.id="+id,
		onok : function(item, dialog){
			gg("crowdfunding_cfReaddress_edit_window").contentWindow.cfReaddress_edit_submit(dialog);
		}
	});
}
