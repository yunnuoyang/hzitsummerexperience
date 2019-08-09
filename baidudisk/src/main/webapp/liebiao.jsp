<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/8/4
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>网盘</title>
    <style>
        body{
            overflow-x: hidden;
            width: 100%;
            height: 100%;
        }
        .header{
            width: 100%;
            height: 62px;
            background: #fff;
            box-shadow: 0 2px 6px 0 rgba(0,0,0,.05);
        }
        .xjjb{
            line-height: 50px;
        }
        .xgs{
            margin: 10px 30px;
        }
        .xgs a{
            text-decoration: none;
            color: #09aaff;
        }
        .layout{
            width: 194px;
            height: 670px;
            top: 62px;
            position: absolute;
            background-color: #F7F7F7;
            margin-top: 20px;
        }
        .abxb{
            list-style: none;
            margin: 0;
            padding: 0;
        }
        .akp{
            width: 194px;
            height: 45px;
            margin-top: 20px;
            color: #666666;
            text-align: center;
        }
        .aa{
            width: 100%;
            margin-left: 200px;
        }
        .aa ul li{
            list-style: none;
            height: 40px;
            line-height: 40px;
        }
        .aa ul li .del{
            color: red;
            float: right;
            cursor: pointer;
            display: inline-block;
        }
        .aaa{
            width: 100%;
            /*height: 80px;*/
            position: absolute;
        }
        .ccc{
            list-style-type: none;
            height: 100px;
        }
        .ccc>li{
            float: left;
            margin: 10px 10px;
        }
        .akp > a{
            text-decoration: none;
        }

        .dd{
            width: 100px;
            height: 40px;
            border-radius: 10px;
            background-color: white;
            color: #09aaff;
            border: 1px solid #09aaff;
        }
        .xx{
            float: right;
            margin-right: 250px;
            margin-top: 10px;
        }
        .xxx{
            list-style-type: none;
            margin-right: 100px;
        }
        .xxx > li{
            float: left;
        }
        .oy{
            float: right;
            width: 300px;
            height: 30px;
            border-radius: 20px;
            border: 1px solid #09aaff;
            background-color: darkgray;
            /*margin-right: 100px;*/
        }
        .ao{
            width: 100px;
            height: 35px;
            border-radius: 20px;
            border: 1px solid #09aaff;
            background-color: #09aaff;
            color: white;
            /*margin-top: 5px;*/
            position: absolute;
        }
        .shadowBox{
            position: fixed;
            left: 0;
            right: 0;
            top: 0;
            bottom: 0;
            display: flex;
            background-color: rgba(0,0,0,.5);
        }
        .shadowBox .box{
            width: 600px;
            height: 400px;
            background: white;
            border-radius: 20px;
            margin: auto;
        }
        .shadowBox .box .top{
            height: 80px;
            line-height: 80px;
            width: 100%;
            background: blue;
            font-size: 50px;
            text-align: center;
            color: white;
            border-radius: 20px 20px 0 0;

        }
        .shadowBox .box .title{
            text-align: center;
            font-size: 30px;
        }
        .title{
            height: 250px;
        }
        #content{
            border-radius: 10px;
            background-color: white;
            color: #09aaff;
            border: 1px solid #09aaff;
        }
        .btn{
            width: 70px;
            height: 25px;
            border-radius: 10px;
            background-color: white;
            color: #09aaff;
            border: 1px solid #09aaff;
        }
    </style>
</head>
<body>
<!--导航部分开始-->
<div id="app">
    <div class="header">
        <dd class="xjjb">
        <span class="xgs">
            <a href="百度云盘.html">首页</a>
        </span>
            <span class="xgs">
            <a href="javascript">网盘</a>
        </span>
            <span class="xgs">
            <a href="javascript">分享</a>
        </span>
            <span class="xgs">
            <a href="javascript">找资源</a>
        </span>
            <span class="xgs">
            <a href="javascript">更多</a>
        </span>
        </dd>
    </div>
    <div class="layout">
        <ul class="abxb">
            <li class="akp"><a href="">全部文件</a></li>
            <li class="akp"><a href="">图片</a></li>
            <li class="akp"><a href="">文档</a></li>
            <li class="akp"><a href="">视频</a></li>
            <li class="akp"><a href="">种子</a></li>
            <li class="akp"><a href="">音乐</a></li>
            <li class="akp"><a href="">其他</a></li>
            <li class="akp"><a href="">我的分享</a></li>
            <li class="akp"><a href="">回收站</a></li>
        </ul>
    </div>
    <div class="aa">
        <div class="aaa">
            <ul class="ccc">
                <li><button class="dd" style="background-color: #09aaff;color: white" type="text" @click="change">上传</button></li>
                <li><button class="dd" type="text">新建文件夹</button></li>
                <li><button class="dd" type="text">离线下载</button></li>
                <li><button class="dd" type="text">我的设备</button></li>
                <div class="xx">
                    <ul class="xxx">
                        <li><input class="oy" type="text" placeholder="搜索你的文件"></li>
                        <li><button class="ao" >搜索</button></li>
                    </ul>
                </div>
            </ul>
            <div>
                <ul>
                    <li v-for="(item,index) in newsList">
                        <span>{{index+1}}</span>
                        // <span>{{item}}</span>
                        <span class="del" @click="delList(index)">删除上传</span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="shadowBox" v-show="key">
            <div class="box">
                <div class="top">文件上传框</div>
                <div class="title">
                    <p>请选择您需要上传的文件</p>
                    <input id="content" name="file" value="点我上传" type="file" v-model="fileName">
                    <button class="btn" @click="addList">上传</button>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
<script>
    const app = new Vue({
        el:'#app',
        data:{
            key:false,
            fileName:'',
            newsList:[]
        },
        methods:{
            change:function () {
                this.key = true;
            }
            ,
            addList:function () {
                if (this.fileName){
                    this.newsList.push(this.fileName);
                    this.fileName = '';
                    this.key = false;
                    $("#content")

                } else {
                    alert('请添加上传文件')
                }
            },
            delList:function (index) {
                this.newsList.splice(index,1)
            }
        }
    })
</script>
</body>
</html>
