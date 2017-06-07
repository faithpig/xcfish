<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<base href="<%=basePath%>">
	<title>xcfish后台管理系统</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/manage/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/manage/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/manage/css/demo.css">
	<script type="text/javascript" src="<%=path %>/manage/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/manage/js/jquery.easyui.min.js"></script>
	<script src="http://cdn.ckeditor.com/4.7.0/standard-all/ckeditor.js"></script>
</head>
<body>
	<h2>xcfish后台管理系统</h2><hr>
	
    
	<div style="margin:20px 0;"></div>
	<div class="easyui-layout" style="width:100%;height:800px;">
		<div data-options="region:'north'" style="height:50px"></div>
		<div data-options="region:'south',split:true" style="height:50px;"></div>
		<div data-options="region:'east',split:true" title="East" style="width:180px;">
			<ul class="easyui-tree" data-options="url:'',method:'get',animate:true,dnd:true"></ul>
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
<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="icon-more" onClick="$('#win2').window('open')">list</a>
<br>
	<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="icon-add" onClick="$('#win').window('open')">add</a>
    <br>
	<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="icon-remove" onclick="confirm1();">remove</a>
    <br>
	<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="icon-edit" onClick="$('#win').window('open')">edit</a>



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
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="confirm1();">Remove</a>

		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onClick="$('#win').window('open')">Edit</a>
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
<table id="tt" class="easyui-datagrid" style="width:950px;height:400px" url="" title="Load Data" iconCls="icon-save" rownumbers="true" pagination="true">
	<thead>
		<tr>
			
			<th field="选择" width="30"></th>
			
			<th field="文章标题" width="340" align="center">文章标题</th>
			<th field="创建时间" width="95" align="center">创建时间</th>
			<th field="更新时间" width="95" align="center">更新时间</th>
			<th field="浏览量" width="50" align="center">浏览量</th>
			<th field="文章id" width="300" align="center">文章id</th>
			
		</tr>

	</thead>
	<c:forEach items="${list}" var="blog" varStatus="status">
		<tr>
			<td><input type="checkbox" value="" name="list_check" style="width:20px;height:20px;"/></td>
			
			<td>${blog.blog_title}</td>
			<td><fmt:formatDate value="${blog.blog_ctime }" type="date" dateStyle="long"/></td>
			<td><fmt:formatDate value="${blog.blog_utime }" type="date" dateStyle="long"/></td>
			<td>${blog.blog_vnum}</td>
			<td>${blog.blog_id}</td>
		</tr>
	</c:forEach>
</table>
					
				</div>
                <div title="添加文章" style="padding:10px" id="win">
                	<div class="easyui-panel" title="New Topic" style="width:100%;max-width:950px;padding:30px 60px;">
		<form id="ff" class="easyui-form" method="post" action="<%=path%>/manage_blog/add" >
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="blog_title" style="width:100%" data-options="label:'Title:',required:true">
			</div>

			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="blog_tag" style="width:100%" data-options="label:'Tag:',required:true">
			</div>
			
			<div style="margin-bottom:20px">         
			<textarea cols="80" id="editor1" name="blog_content" rows="10" >&lt;p&gt;This is some &lt;strong&gt;sample text&lt;/strong&gt;. You are using CKEditor&lt;/a&gt;.&lt;/p&gt;</textarea>
			<script>
				CKEDITOR.replace( 'editor1', {
					uiColor: '#e5efff'
				} );
			</script>
			</div>
			
			<div style="margin-bottom:20px">
				<select class="easyui-combobox" name="blog_subject" label="分类" style="width:100%" contenteditable="false">
				<option value="技术">技术</option>
				<option value="抒情">抒情</option>
				</select>
			</div>
			<input type="submit" value="哈哈"/>
		</form>
		<div style="text-align:center;padding:5px 0">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
		</div>
	</div>
	<script>
		function submitForm(){
			$('#ff').submit();
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