# DeepLink
## Định nghĩa
- Deep link là các đường dẫn được chia sẻ trên nền tảng mobile, vận hành khá giống hyperlink nhưng thay vì dẫn người dùng đến ngay một địa chỉ web page nào đó, deep link dẫn họ tới một màn hình cụ thể ngay trong ứng dụng.
- Lợi ích lớn nhất của deeolink trên thiết bị di động là khả năng các nhà tiếp thị và nhà phát triển ứng dụng đưa người dùng trực tiếp vào vị trí cụ thể trong ứng dụng của họ bằng một liên kết chuyên dụng. Cũng giống như deeplink làm cho web trở nên hữu dụng hơn, deeplink mobile cũng làm tương tự cho các ứng dụng di động.
- Không giống như các deeplink trên web, nơi định dạng liên kết được chuẩn hóa dựa trên các nguyên tắc HTTP , các deeplink trên thiết bị di động không tuân theo một định dạng nhất quán. Điều này gây ra sự nhầm lẫn trong phát triển vì các bộ liên kết khác nhau được yêu cầu để truy cập cùng một ứng dụng trên một hệ điều hành di động khác.
- Định dạng của URI được sử dụng để kích hoạt deeplink một ứng dụng thường khác nhau tùy thuộc vào hệ điều hành mobile. Các thiết bị Android hoạt động thông qua intent, BlackBerry 10 hoạt động thông qua khung gọi của BB10, ios hoạt động thông qua openUrl,và các thiết bị Windows Phone 8 hoạt động thông qua lớp UriMapper.
- fb://profile/33138223345là một ví dụ về một deeplink. URI chứa tất cả thông tin cần thiết để khởi chạy trực tiếp vào một vị trí cụ thể trong một ứng dụng, trong trường hợp này là profile có id '33138223345'
## Các loại Deeplink
- Deeplink là một liên kết điều hướng đến một phần nội dung. Đây là phần chung nhất của link. Trong đa số các trường hợp, người dùng sẽ thấy ứng dụng đăng kí deeplink với "open with" dialog
- Deeplink có thể sử dụng custom URI scheme như myapp://
- Deeplink có thể sử dụng URI schemes trỏ đến tài nguyên qua mạng. Ví dụ, https:// . Trong trường hợp đó, ta có thể nói đó là một URK
- Android App Link (API 23+) là một HTTP URL Deeplink có thể đưa người dùng trực tiếp đến màn hình ứng dụng. Thiết lập trang web tương ứng là required nếu muốn xác định quyền sở hữu cho liên kết
- Có một loại DeepLink nữa là Deferred Deep Link. Nó cho phép xử lý tham số cụ thể (ví dụ productId) trong trường hợp nếu ứng dụng chưa được cài đặt và người dùng đã gửi đến Play Store. Sau khi cài đặt ứng dụng, người dùng sẽ được điều hướng đến màn hình mong đợi. 
### Deeplink trong Android
### Tạo deeplink trong Android
- Khi click vào link hoặc yêu cầu gọi intent URI, Android system sẽ làm từng hành động sau, thứ tự liên tục cho đến khi request thành công
1. Mở preferred app có thể handler URI, nếu ứng dụng được chỉ định
2. Mở ứng dụng có sẵn duy nhất có thể sử lý URI
3. Cho phép người dùng chọn ứng dụng từ dialog

- Để tạo deeplink, ta cần add Intent Filter vào manifest của ứng dụng:

<action>
Chỉ ACTION_VIEWđịnh hành động mục đích để có thể đạt được bộ lọc ý định từ Tìm kiếm của Google.
  
<data>
Có thể có nhiều thẻ <data>, mỗi thẻ đại diện cho định dạng URI phân giải hoạt động. Ít nhất, <data> phải bao gồm thuộc tính android:scheme.
Ta có thể thêm nhiều thuộc tính để thêm loại URI mà activity chấp nhận. Ví dụ: có thể có nhiều hoạt động chấp nhận các URI tương tự, nhưng khác nhau chỉ đơn giản dựa trên tên đường dẫn. Trong trường hợp này, sử dụng các android:paththuộc tính hoặc của nó pathPatternhoặc pathPrefixcác biến thể để phân biệt mà hoạt động hệ thống sẽ mở các đường dẫn URI khác nhau.

<category>
Bao gồm các BROWSABLE. Nó được yêu cầu intenFilter có thể truy cập được từ trình duyệt web. Không có nó, nhấp vào một liên kết trong trình duyệt có thể giải quyết cho ứng dụng của bạn.
Cũng bao gồm các DEFAULTthể loại. Điều này cho phép ứng dụng của bạn phản hồi lại implicit intent. Không có điều này, activity chỉ có thể được bắt đầu nếu mục đích chỉ định tên thành phần ứng dụng của bạn.

Đoạn XML sau đây cho thấy cách có thể chỉ định intenFilter trong Manifest để tạo deeplink. 
