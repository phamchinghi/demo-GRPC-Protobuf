# Những gì biết về _gRPC_ & _Protobuf_

### GRPC:
là framework RPC mã nguồn mở được phát triển bởi google để tối ưu hóa, nâng cao hiệu quả cho trang web. Tăng tốc việc giao tiếp giữa các service trong Microservice.
Có 4 loại trao đổi giữa client và server
- **Unary gRPC**: client và server chỉ gửi 1 req và nhận 1 res trên 1 lần trao đổi.
	- vd: tạo res và req cho clien và server. Cần tạo 1 service và trong service khai báo các hàm và res req cần:
	```
		Service demo{
			rpc Demo(demorequest) returns (demoresponse);
		}

- **Client streaming**: ở client có thể gửi 1 luồng nhiều req đến server và server đợi đến khi client gửi hết thì sẽ đọc và trả lại 1 res.
	- vd:
	```
		Service demo{
			rpc Demo(stream demorequest) returns (demoresponse);
		}
- **Server streaming**: ngược lại với client streaming.
	- vd: 
	```
		Service demo{
			rpc Demo(demorequest) returns (stream demoresponse);
		}
- **Bidirectional streaming**: client và server đều có thể đọc và ghi thông tin thông qua luồng với nhiều req và res. Hai luồng này hoạt động độc lập, client và server có thể đọc và ghi theo bất kì thứ tự nào.
	-  vd: 
	```
		Service demo{
			rpc Demo(stream demorequest) returns (stream demoresponse);
		}
### GRPC dựa vào HTTP/2 và Protobuf để transfer data

- **HTTP/2**: là giao thức được nâng cấp lên của HTTP/1.1 nó giúp cải thiện tốc độ giao tiếp giữa client và server nên web nhanh hơn.

- **Protocol Buffer**: hay còn gọi là protobuf là language-neutral, platform-neutral của google về cơ bản nó được sủ dụng để Serialized object, có vẻ nó khá giống XML hoặc JSON. Nó lưu trữ dữ liệu có cấu trúc có thể được Serialize hoặc De-Serialized tự động bởi nhiều ngôn ngữ khác nhau.
	+ Tất cả những gì phải làm là chỉ định một message cho từng cấu trúc dữ liệu mà muốn Serialize bằng cách sử dụng file đặc tả .proto
	+ Sau đó từ file .proto compiler của protobuf ( protoc ) tạo ra code thực hiện encode tự động và phân tích cú pháp dữ liệu protobuf với định dạng Binary, tùy thuộc vào từng ngôn ngữ nó sẽ tạo ra mã tương ứng

### So sánh giữa Protobuf, XML và JSON
- Protobuf
	+ Dữ liệu rất dày đặc, đầu ra nhỏ.
	+ Khó decode mà không biết schema, định dạng dữ liệu không rõ ràng và cần schema để biết rõ.
	+ Xử lý rất nhanh, nhỏ hơn 3 - 10 lần so với XML hoặc JSON
	+ Không dành cho con người vì là Binary.
	+ Tạo các code truy cập dữ liệu dễ sử dụng hơn theo chương trình.
- JSON
	+ Con người có thể có thể đọc và chỉnh sửa dễ dàng.
	+ Có thể phân tích cú pháp mà không cần biết schema.
	+ Các browser đều hỗ trợ rất tốt.
	+ Ít dài dòng hơn XML.
- XML
	+ Con người có thể có thể đọc và chỉnh sửa dễ dàng.
	+ Có thể phân tích cú pháp mà không cần biết schema.
	+ Tiêu chuẩn cho SOAP...
	+ Hỗ trợ tốt các công cụ như xsd, xslt, sax, dom ...

### Những hạn chế không nên sử dụng:
- Khi cần hoặc muốn dữ liệu con người có thể đọc dễ dàng.
- Dữ liệu từ Service được sử dụng trực tiếp bởi Browser.
- Server viết bằng ngôn ngư khác như Javascript.
- Gánh nặng hoạt động của việc vận hành một loại dịch vụ mạng khác là quá lớn.
