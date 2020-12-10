# API 定义的基础类
> 该模块应该为所有项目的公共引用部分，源码不应该出现在某个项目内，这里只作演示使用

## Request
分为两个对象，一个是带分页， 一个是不带分页，
排序条件只有在分页中可用，数据量少请在前端排序处理
> * ApiSimpleRequest
> > 简单的查询对象，用例
     ```java
    ApiSimpleRequest<String>
    ```
> * ApiRequest
> > 带分页的查询对象

## Response
分为两个对象，一个带分页信息，一个不带`ApiSimpleResponse` `ApiResponse`

## 使用技巧
两种对象都直接提供了 `simple` 方法直接生成对象，现时支持 `流式接口`