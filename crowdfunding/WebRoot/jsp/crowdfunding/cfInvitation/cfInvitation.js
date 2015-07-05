var cfInvitation_grid = null;
var cfInvitation_toolbar = {
	items : [ {
		line : true
	}, {
		text : "增加",
		click : cfInvitation_add,
		icon : "add"
	}, {
		line : true
	} ]
};

$(function() {
	var g = {
		gridid : "crowdfunding_cfInvitation_grid",
		condition : "cfInvitationCondition",
		url : basePath+"admin/crowdfunding/cfInvitation!data.action",
		formid : "crowdfunding_cfInvitation_form",
		toolbar : cfInvitation_toolbar,
		checkbox : false,
		columns : [
				{
					display : "操作",
					name : "id",
					render : function(item) {
						var html = "<a href='javascript:;' onclick='cfInvitation_delete(\""
								+ item.id
								+ "\")' class='linkbutton'>删除</a>";
						html += "<a href='javascript:;' onclick='cfInvitation_edit(\""
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
					display : "beInvitedUserid",
					name : "beInvitedUserid"
				},
				{
					display : "award",
					name : "award"
				},
				{
					display : "isEffect",
					name : "isEffect"
				},
				{
					display : "createTime",
					name : "createTime"
				},
		]
	};
	cfInvitation_grid = showGrid(g);
});

function cfInvitation_search() {
	cfInvitation_grid.loadData();
}

function cfInvitation_delete(id) {
	confirm("删除操作", "确认删除吗？", function() {
		$.getJSON(basePath+"admin/crowdfunding/cfInvitation!delete.action?cfInvitation.id=" + id,function(json) {
			if (json.success) {
				cfInvitation_grid.loadData();
			}else{
				alert(json.message,"error");
			}
		});
	});
}

function cfInvitation_add() {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_cfInvitation_add_window",
		url : basePath+"admin/crowdfunding/cfInvitation!toAdd.action",
		onok : function(item, dialog){
			gg("crowdfunding_cfInvitation_add_window").contentWindow.cfInvitation_add_submit(dialog);
		}
	});
}

function cfInvitation_edit(id) {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_cfInvitation_edit_window",
		url : basePath+"admin/crowdfunding/cfInvitation!toEdit.action?cfInvitation.id="+id,
		onok : function(item, dialog){
			gg("crowdfunding_cfInvitation_edit_window").contentWindow.cfInvitation_edit_submit(dialog);
		}
	});
}
