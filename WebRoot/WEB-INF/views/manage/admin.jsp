<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<base href="<%=basePath%>">
	<title>xcfish后台管理系统</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
	<h2>xcfish后台管理系统</h2><hr>
	
    
	<div style="margin:20px 0;"></div>
	<div class="easyui-layout" style="width:100%;height:800px;">
		<div data-options="region:'north'" style="height:50px"></div>
		<div data-options="region:'south',split:true" style="height:50px;"></div>
		<div data-options="region:'east',split:true" title="East" style="width:180px;">
			<ul class="easyui-tree" data-options="url:'tree_data1.json',method:'get',animate:true,dnd:true"></ul>
		</div>
		<div data-options="region:'west',split:true" title="导航窗格" style="width:180px;">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="文章管理"  data-options="selected:true" style="padding:10px;">
<script>
function confirm1(){
			$.messager.confirm('My Title', 'Are you confirm this?', function(r){
				if (r){
					alert('confirmed: '+r);
				}
			});
		}
</script>
<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-more" onClick="$('#win2').window('open')">list</a>
<br>
	<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add" onClick="$('#win').window('open')">add</a>
    <br>
	<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-remove" onclick="confirm1();">remove</a>
    <br>
	<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-edit" onClick="$('#win').window('open')">edit</a>



				</div>
				<div title="Title2"style="padding:10px;">
					content2
				</div>
				<div title="Title3" style="padding:10px">
					content3
				</div>
			</div>
		</div>
		<div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
			<div class="easyui-tabs" data-options="fit:true,border:false,plain:true">

				<div title="文章列表" style="padding:5px" id="win2">
                	<div style="padding:5px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onClick="$('#win').window('open')">Add</a>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="confirm1();">Remove</a>

		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onClick="$('#win').window('open')">Edit</a>
	</div>

<div id="tb" style="padding:3px">
	<span>title</span>
	<input id="itemid" style="line-height:26px;border:1px solid #ccc">
	<span>content</span>
	<input id="productid" style="line-height:26px;border:1px solid #ccc">
	<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">Search</a>
<script>
function doSearch(){
	$('#tt').datagrid('load',{
		itemid: $('#itemid').val(),
		productid: $('#productid').val()
	});
}
</script>
</div>
<table id="tt" class="easyui-datagrid" style="width:950px;height:400px"
		url="datagrid2_getdata.php"
		title="Load Data" iconCls="icon-save"
		rownumbers="true" pagination="true">
	<thead>
		<tr>
			<th field="itemid" width="80">Item ID</th>
			<th field="productid" width="80">Product ID</th>
			<th field="listprice" width="80" align="right">List Price</th>
			<th field="unitcost" width="80" align="right">Unit Cost</th>
			<th field="attr1" width="150">Attribute</th>
			<th field="status" width="60" align="center">Stauts</th>
		</tr>
	</thead>
</table>
					
				</div>
                <div title="添加文章" style="padding:10px" id="win">
                	<div class="easyui-panel" title="New Topic" style="width:100%;max-width:950px;padding:30px 60px;">
		<form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="name" style="width:100%" data-options="label:'Name:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="email" style="width:100%" data-options="label:'Email:',required:true,validType:'email'">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="subject" style="width:100%" data-options="label:'Subject:',required:true">
			</div>
			<div style="margin-bottom:20px">
            <script src="http://cdn.ckeditor.com/4.7.0/standard-all/ckeditor.js"></script>
		<textarea cols="80" id="editor1" name="editor1" rows="10" >&lt;p&gt;This is some &lt;strong&gt;sample text&lt;/strong&gt;. You are using CKEditor&lt;/a&gt;.&lt;/p&gt;
	</textarea>

	<script>
		CKEDITOR.replace( 'editor1', {
			uiColor: '#e5efff'
		} );
	</script>
			</div>
			<div style="margin-bottom:20px">
				<select class="easyui-combobox" name="language" label="Language" style="width:100%"><option value="ar">Arabic</option><option value="bg">Bulgarian</option><option value="ca">Catalan</option><option value="zh-cht">Chinese Traditional</option></select>
			</div>
		</form>
		<div style="text-align:center;padding:5px 0">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
		</div>
	</div>
	<script>
		function submitForm(){
			$('#ff').form('submit',{
				onSubmit:function(){
					return $(this).form('enableValidation').form('validate');
				}
			});
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
                </div>
                
                

			</div>
		</div>
	</div>
</body>
</html>