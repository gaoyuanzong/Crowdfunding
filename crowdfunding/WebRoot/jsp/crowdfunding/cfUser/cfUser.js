var cfUser_grid = null;
var cfUser_toolbar = {
	items : [ {
		line : true
	}, {
		text : "增加",
		click : cfUser_add,
		icon : "add"
	}, {
		line : true
	} ]
};

$(function() {
	var g = {
		gridid : "crowdfunding_cfUser_grid",
		condition : "cfUserCondition",
		url : basePath+"admin/crowdfunding/cfUser!data.action",
		formid : "crowdfunding_cfUser_form",
		toolbar : cfUser_toolbar,
		checkbox : false,
		columns : [
				{
					display : "操作",
					name : "id",
					render : function(item) {
						var html = "<a href='javascript:;' onclick='cfUser_delete(\""
								+ item.id
								+ "\")' class='linkbutton'>删除</a>";
						html += "<a href='javascript:;' onclick='cfUser_edit(\""
								+ item.id
								+ "\")' class='linkbutton'>修改</a>";
						return html;
					}
				},
				// columns start
				{
					display : "userName",
					name : "userName"
				},
				{
					display : "petName",
					name : "petName"
				},
				{
					display : "realName",
					name : "realName"
				},
				{
					display : "phone",
					name : "phone"
				},
				{
					display : "isPhone",
					name : "isPhone"
				},
				{
					display : "mail",
					name : "mail"
				},
				{
					display : "isMail",
					name : "isMail"
				},
				{
					display : "idNumber",
					name : "idNumber"
				},
				{
					display : "backPath",
					name : "backPath"
				},
				{
					display : "frontPath",
					name : "frontPath"
				},
				{
					display : "isIdentity",
					name : "isIdentity"
				},
				{
					display : "province",
					name : "province"
				},
				{
					display : "citys",
					name : "citys"
				},
				{
					display : "address",
					name : "address"
				},
				{
					display : "personalStatement",
					name : "personalStatement"
				},
				{
					display : "invitationCode",
					name : "invitationCode"
				},
				{
					display : "personalCode",
					name : "personalCode"
				},
				{
					display : "filePath",
					name : "filePath"
				},
				{
					display : "isLock",
					name : "isLock"
				},
				{
					display : "isActivate",
					name : "isActivate"
				},
				{
					display : "registerTime",
					name : "registerTime"
				},
				{
					display : "lastLoginTime",
					name : "lastLoginTime"
				},
		]
	};
	cfUser_grid = showGrid(g);
});

function cfUser_search() {
	cfUser_grid.loadData();
}

function cfUser_delete(id) {
	confirm("删除操作", "确认删除吗？", function() {
		$.getJSON(basePath+"admin/crowdfunding/cfUser!delete.action?cfUser.id=" + id,function(json) {
			if (json.success) {
				cfUser_grid.loadData();
			}else{
				alert(json.message,"error");
			}
		});
	});
}

function cfUser_add() {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_cfUser_add_window",
		url : basePath+"admin/crowdfunding/cfUser!toAdd.action",
		onok : function(item, dialog){
			gg("crowdfunding_cfUser_add_window").contentWindow.cfUser_add_submit(dialog);
		}
	});
}

function cfUser_edit(id) {
	showDialog({
		title : "新建考试",
		name : "crowdfunding_cfUser_edit_window",
		url : basePath+"admin/crowdfunding/cfUser!toEdit.action?cfUser.id="+id,
		onok : function(item, dialog){
			gg("crowdfunding_cfUser_edit_window").contentWindow.cfUser_edit_submit(dialog);
		}
	});
}
