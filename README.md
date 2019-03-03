# DeepLink
## Định nghĩa
- Deep link là các đường dẫn được chia sẻ trên nền tảng mobile, vận hành khá giống hyperlink nhưng thay vì dẫn người dùng đến ngay một địa chỉ web page nào đó, deep link dẫn họ tới một màn hình cụ thể ngay trong ứng dụng.
- Lợi ích lớn nhất của deeolink trên thiết bị di động là khả năng các nhà tiếp thị và nhà phát triển ứng dụng đưa người dùng trực tiếp vào vị trí cụ thể trong ứng dụng của họ bằng một liên kết chuyên dụng. Cũng giống như deeplink làm cho web trở nên hữu dụng hơn, deeplink mobile cũng làm tương tự cho các ứng dụng di động.
- Không giống như các deeplink trên web, nơi định dạng liên kết được chuẩn hóa dựa trên các nguyên tắc HTTP , các deeplink trên thiết bị di động không tuân theo một định dạng nhất quán. Điều này gây ra sự nhầm lẫn trong phát triển vì các bộ liên kết khác nhau được yêu cầu để truy cập cùng một ứng dụng trên một hệ điều hành di động khác.
## Các loại Deeplink
- Deeplink là một liên kết điều hướng đến một phần nội dung. Đây là phần chung nhất của link. Trong đa số các trường hợp, người dùng sẽ thấy ứng dụng đăng kí deeplink với "open with" dialog
- Deeplink có thể sử dụng custom URI scheme như myapp://
- Deeplink có thể sử dụng URI schemes trỏ đến tài nguyên qua mạng. Ví dụ, https:// . Trong trường hợp đó, ta có thể nói đó là một URK
- Android App Link (API 23+) là một HTTP URL Deeplink có thể đưa người dùng trực tiếp đến màn hình ứng dụng. Thiết lập trang web tương ứng là required nếu muốn xác định quyền sở hữu cho liên kết
- Có một loại DeepLink nữa là Deferred Deep Link. Nó cho phép xử lý tham số cụ thể (ví dụ productId) trong trường hợp nếu ứng dụng chưa được cài đặt và người dùng đã gửi đến Play Store. Sau khi cài đặt ứng dụng, người dùng sẽ được điều hướng đến màn hình mong đợi. 
