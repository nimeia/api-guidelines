# API 开发规范

## 项目结构说明
### base api 
> 演示api 中的一些通用定义

### client项目
> 演示客户端调用

### server 项目
> 演示服务端相关定义

### api-define项目
演示如何定义api

### 编码

统一使用UTF-8

## API分类
### 原则
提供到外部调用的统一使用 `RESTFUL API` , 项目内各个模块根据不同的情况可以使用不同的`RPC API`

### 外部API
> 主要定义提供给本系统外的服务调用，依赖应该最少化，同时提供明确的文档与版本定义，
> 建议独立部署，如果不能满足独立部署，刚应该提供统一的`URL`前缀访问，方便进行权限控制

### WEB API 
> 提供给当前项目的前端调用的`WEB API`,例如 `ANGULAR`  `VUE` `REACTJS` 等调用，
> 如果项目提供单独的域名,建议所有 `URL` 部署到 `/` 上，如果与 `外部API` 部署在同一个域名上，
> 应该区别于其 `URL`

### SERVICE API
> 系统内部各个部分模块间调用的 `API`,一般不进行权限控制，
> 同时该类API 不强制使用 `RESTFUL API` ,你可以根据具体的项目使用不同的 `RPC API`
> 例如 `DUBBO` `MOTAN` 等

## API 安全
> * `外部API` 与 `WEB API` 应该提供不同的权限认证，用户通常不是同一类用户。
> * 权限控制可以使用网关统一处理。
> * 内部模块间的`API`不做权限管理，便`本项目外的调用API`被认定为`外部API`。
> * `外部API` 与 `WEB API` 处理外部输入参数时，需要处理 `XSS` , `SQL注入`等常见漏洞。
> * `外部API` 与 `WEB API` 需要返回用户信息时需要处理敏感信息，避免一些非法使用。
> * `外部API` 与 `WEB API` 需要防止越权调用，使用通过`用户id` ,`订单id`等遍历数据。
> * `API` 设计时应该避免在`URL`中传递敏感信息，避免在日志，浏览器记录等留下信息
> * 代码错误信息禁止返回到前台，可以返回错误key 再与后端具体错误关联

## API 请求与返回规范
### 请求规范
> 当请求参数为非基本数据类型时，请用一个`request`对象进行包裹，这是因为一些 `reset api` 框架不支持从json中反序列化为多个对象
> 当为基本数据类型时，在`restful api` 中可以通过`url` 参数或者 `form` 表单传递
> 如果可以，需要对 `API` 参数进行设计，对公共部分最小化提取，但需要注意公共部分不包括关键敏感数据，例如密码，邮箱 ，电话号等，避免黑客的一些攻击

### 返回规范
> 返回对象应该使用 `response` 基础对象进行再封装

### HTTP Code
> * 不建议返回200 外的任何 http status code，302这样的功能除外
> * 这个可能与其它规范中的不一样，这主要出于进一步减少对开发人员的要求与理解难度
> * 返回 200 外的 status code 可能导致客户端无法正常处理，部分客户端根本没有处理这样的例外的代码逻辑，这样可能导致难以排查问题。

### 样例   [baseapi](baseapi/readme.md)

## HTTP 谓词使用

> 对于 `http` 谓词使用，本规范只建议使用 `GET` 与 `POST` 
> 原因如下:
>
> * 人的原因，由于一些新人或者没有http 协议相关经验的人可能并不清楚其它谓词的作用
> * `POST` `PUT` `PATCH` 可能引起误解
> * 语义化 `URL` 更加方便统计数据与权限控制 

HTTP 协议定义了大量为请求赋于语义的方法。 大多数 RESTful Web API 使用的常见 HTTP 方法是：

> * GET 检索位于指定 URI 处的资源的表示形式。 响应消息的正文包含所请求资源的详细信息。
> * POST 在指定的 URI 处创建新资源。 请求消息的正文将提供新资源的详细信息。 请注意，POST 还用于触发不实际创建资源的操作。
> * PUT 在指定的 URI 处创建或替换资源。 请求消息的正文指定要创建或更新的资源。
> * PATCH 对资源执行部分更新。 请求正文包含要应用到资源的一组更改。
> * DELETE 删除位于指定 URI 处的资源。

## URL 设计规范
> * 各个系统或者模块之间的 `url`需要通过设计后才能使用，不能随意定义。
>
> * 每个系统或者模块需要可以通过 `url`前缀区分，不能混用，这样可以方便权限，分发等配置。
>
> * `url` 的名称应该简单，不适合过长，同时具体业务意义，开发人员可以按`url`猜测出作用
>
> * `url` 应该包括几个部分：`集合(collection)` ， `操作(action)`
>
> * `action` 习惯为 
>
>   | 动作           | 说明                                               |
>   | -------------- | -------------------------------------------------- |
>   | modify\|update | 修改一个对象                                       |
>   | remove\|delete | 删除一个对象                                       |
>   | make \| create | 创建一个业务对象                                   |
>   | find           | 查找单个对象或者固定大小的集合（集合数据一般较少） |
>   | search         | 查找，一般需要分页处理                             |
>
> * 使用 `find` 而不是`get` , 减少代码中 `bean` 方法歧义
>
> * 当部分防火墙检查sql关键字时，使用（`modify`，`remove`，`make`）代替（`update`，`delete`，`create`）


**建议样例**

``` html
https://api.com/{collection/{action}?parms=*
```
~~**不建议样例**~~
~~`https://api.com/orders/1`~~ 这不方便从日志里统计，这可能与其它的规范完全不一致。

#### 数据筛选和分页

通过单个 URI 公开资源的集合可能会导致应用程序在只需一部分信息时提取大量数据。 例如，假设某个客户端应用程序需要查找成本超过特定值的所有订单。 它可以从 /orders URI 检索所有订单，然后在客户端筛选这些订单。 显然，此过程的效率非常低下。 它浪费了托管 Web API 的服务器的网络带宽和处理能力。

## 媒体类型
在 `HTTP` 协议中，格式是使用媒体类型（也称为 `MIME` 类型）指定的。 对于非二进制数据，大多数 `Web API` 支持 `JSON`（媒体类型 = `application/json`），可能还支持 XML（媒体类型 = `application/xml`）
例子

``` http request
POST https://api.com/orders HTTP/1.1
Content-Type: application/json; charset=utf-8
Content-Length: 57

{"Id":1,"Name":"Gizmo","Category":"Widgets","Price":1.99}
```
#### 异步操作
有时，某 操作可能需要处理操作需要一段时间才能完成。 如果需要等待该操作完成后才能向客户端发送响应，可能会造成不可接受的延迟。 在这种情况下，请考虑将该操作设置为异步操作。 返回 HTTP 状态代码 202（已接受），指示该请求已接受进行处理，但尚未完成。

## 客户端操作规范

### 编码

统一使用UTF-8

#### 循环调用

避免在循环中调用接口，可以通过一次传递多个参数查询所需结果

### 超时控制

客户端需要超时控制

### 客户端耦合

当服务器端提供客户端代码时，注意避免业务代码中直接使用该程序包中的对象

## 参考

### HTTP 请求方法

HTTP 定义了一组**请求方法**, 以表明要对给定资源执行的操作。指示针对给定资源要执行的期望动作. 虽然他们也可以是名词, 但这些请求方法有时被称为HTTP动词. 每一个请求方法都实现了不同的语义, 但一些共同的特征由一组共享：: 例如一个请求方法可以是 [safe](https://developer.mozilla.org/zh-CN/docs/Glossary/safe), [idempotent](https://developer.mozilla.org/zh-CN/docs/Glossary/幂等), 或 [cacheable](https://developer.mozilla.org/en-US/docs/Glossary/cacheable).

- `GET`

  GET方法请求一个指定资源的表示形式. 使用GET的请求应该只被用于获取数据.

- `HEAD`

  HEAD方法请求一个与GET请求的响应相同的响应，但没有响应体.

- `POST`

  POST方法用于将实体提交到指定的资源，通常导致在服务器上的状态变化或副作用. 

- `PUT`

  PUT方法用请求有效载荷替换目标资源的所有当前表示。

- `DELETE`

  DELETE方法删除指定的资源。

- `CONNECT`

  CONNECT方法建立一个到由目标资源标识的服务器的隧道。

- `OPTIONS`

  OPTIONS方法用于描述目标资源的通信选项。

- `TRACE`

  TRACE方法沿着到目标资源的路径执行一个消息环回测试。

- `PATCH`

  PATCH方法用于对资源应用部分修改。

### http status code 

https://httpstatuses.com/

```
1×× Informational
100 Continue
101 Switching Protocols
102 Processing
2×× Success
200 OK
201 Created
202 Accepted
203 Non-authoritative Information
204 No Content
205 Reset Content
206 Partial Content
207 Multi-Status
208 Already Reported
226 IM Used
3×× Redirection
300 Multiple Choices
301 Moved Permanently
302 Found
303 See Other
304 Not Modified
305 Use Proxy
307 Temporary Redirect
308 Permanent Redirect
4×× Client Error
400 Bad Request
401 Unauthorized
402 Payment Required
403 Forbidden
404 Not Found
405 Method Not Allowed
406 Not Acceptable
407 Proxy Authentication Required
408 Request Timeout
409 Conflict
410 Gone
411 Length Required
412 Precondition Failed
413 Payload Too Large
414 Request-URI Too Long
415 Unsupported Media Type
416 Requested Range Not Satisfiable
417 Expectation Failed
418 I'm a teapot
421 Misdirected Request
422 Unprocessable Entity
423 Locked
424 Failed Dependency
426 Upgrade Required
428 Precondition Required
429 Too Many Requests
431 Request Header Fields Too Large
444 Connection Closed Without Response
451 Unavailable For Legal Reasons
499 Client Closed Request
5×× Server Error
500 Internal Server Error
501 Not Implemented
502 Bad Gateway
503 Service Unavailable
504 Gateway Timeout
505 HTTP Version Not Supported
506 Variant Also Negotiates
507 Insufficient Storage
508 Loop Detected
510 Not Extended
511 Network Authentication Required
599 Network Connect Timeout Error
```
