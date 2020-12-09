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

## URL 设计规范

建议
``` html
https://api.com/{collection/{action}?parms=*
```
不建议
`https://adventure-works.com/orders/1`

### http 谓词使用

HTTP 协议定义了大量为请求赋于语义的方法。 大多数 RESTful Web API 使用的常见 HTTP 方法是：

> * GET 检索位于指定 URI 处的资源的表示形式。 响应消息的正文包含所请求资源的详细信息。
> * POST 在指定的 URI 处创建新资源。 请求消息的正文将提供新资源的详细信息。 请注意，POST 还用于触发不实际创建资源的操作。
> * PUT 在指定的 URI 处创建或替换资源。 请求消息的正文指定要创建或更新的资源。
> * PATCH 对资源执行部分更新。 请求正文包含要应用到资源的一组更改。
> * DELETE 删除位于指定 URI 处的资源。

### 媒体类型
在 `HTTP` 协议中，格式是使用媒体类型（也称为 `MIME` 类型）指定的。 对于非二进制数据，大多数 `Web API` 支持 `JSON`（媒体类型 = `application/json`），可能还支持 XML（媒体类型 = `application/xml`）
例子
``` http request
POST https://adventure-works.com/orders HTTP/1.1
Content-Type: application/json; charset=utf-8
Content-Length: 57

{"Id":1,"Name":"Gizmo","Category":"Widgets","Price":1.99}
```
如果服务器不支持媒体类型，则应返回 HTTP 状态代码 415（不支持的媒体类型）。
客户端请求可以包含一个 Accept 标头，该标头包含客户端可以接受的、来自服务器的响应消息中的媒体类型列表。 例如：
``` http request
GET https://adventure-works.com/orders/2 HTTP/1.1
Accept: application/json
```
#### GET 方法
成功的 GET 方法通常返回 HTTP 状态代码 200（正常）。 如果找不到资源，该方法应返回 404（未找到）。
#### POST 方法
如果 POST 方法创建了新资源，则会返回 HTTP 状态代码 201（已创建）。 新资源的 URI 包含在响应的 Location 标头中。 响应正文包含资源的表示形式。
如果该方法执行了一些处理但未创建新资源，则可以返回 HTTP 状态代码 200，并在响应正文中包含操作结果。 或者，如果没有可返回的结果，该方法可以返回 HTTP 状态代码 204（无内容）但不返回任何响应正文。
如果客户端将无效数据放入请求，服务器应返回 HTTP 状态代码 400（错误的请求）。 响应正文可以包含有关错误的其他信息，或包含可提供更多详细信息的 URI 链接。

#### 异步操作
有时，POST、PUT、PATCH 或 DELETE 操作可能需要处理操作需要一段时间才能完成。 如果需要等待该操作完成后才能向客户端发送响应，可能会造成不可接受的延迟。 在这种情况下，请考虑将该操作设置为异步操作。 返回 HTTP 状态代码 202（已接受），指示该请求已接受进行处理，但尚未完成。

#### 返回http code
只返回 200

#### 数据筛选和分页
通过单个 URI 公开资源的集合可能会导致应用程序在只需一部分信息时提取大量数据。 例如，假设某个客户端应用程序需要查找成本超过特定值的所有订单。 它可以从 /orders URI 检索所有订单，然后在客户端筛选这些订单。 显然，此过程的效率非常低下。 它浪费了托管 Web API 的服务器的网络带宽和处理能力。
API 可以允许在 URI 的查询字符串中传递筛选器，例如 /orders?minCost=n。 然后，Web API 负责分析和处理查询字符串中的 minCost 参数并在服务器端返回筛选后的结果。
对集合资源执行的 GET 请求可能返回大量的项。 应将 Web API 设计为限制任何单个请求返回的数据量。 请考虑支持查询字符串指定要检索的最大项数和集合中的起始偏移量。 例如：
HTTP

复制
/orders?limit=25&offset=50
此外，请考虑对返回的项数指定上限，以防拒绝服务攻击。 若要帮助客户端应用程序，返回分页数据的 GET 请求还应包含某种形式的元数据，以指示集合中可用的资源总数。

#### 对 RESTful Web API 进行版本控制

#### 程序入口
An "endpoint" is a combination of two things:

The verb (e.g. GET or POST)
The URL path (e.g. /articles)
Information can be passed to an endpoint in either of two ways:

The URL query string (e.g. ?year=2014)
HTTP headers (e.g. X-Api-Key: my-key)


#### Use a consistent date format
And specifically, use ISO 8601, in UTC.

For just dates, that looks like 2013-02-27. For full times, that's of the form 2013-02-27T10:00:00Z.

This date format is used all over the web, and puts each field in consistent order -- from least granular to most granular.

### Always use HTTPS

#### Use UTF-8

####http status code 
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
