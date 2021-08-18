Những gì biết về gRPC & Protobuf:
	GRPC: là framework RPC mã nguồn mở được phát triển bởi google
	Có 4 loại trao đổi giữa client và server
	- Unary gRPC: client và server chỉ gửi 1 req và nhận 1 res trên 1 lần trao đổi.
	- Client streaming: ở client có thể gửi 1 luồng nhiều req và server chỉ có thể trả lại 1 res 1 lần.
	- Server streaming: ngược lại với client streaming.
	- Bidirectional streaming: client và server đều có thể trao đổi qua lại thông qua 1 luồng với nhiều req và res.
	GRPC dựa vào HTTP/2 và Protobuf để transfer data
