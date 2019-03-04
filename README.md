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
- ACTION_VIEW chỉ định hành động mục đích để có thể đạt được bộ lọc ý định từ Tìm kiếm của Google.

  <data>
- Có thể có nhiều thẻ <data>, mỗi thẻ đại diện cho định dạng URI phân giải hoạt động. Ít nhất, <data> phải bao gồm thuộc tính android:scheme.
  - Ta có thể thêm nhiều thuộc tính để thêm loại URI mà activity chấp nhận. Ví dụ: có thể có nhiều activity chấp nhận các URI tương tự, nhưng khác nhau chỉ đơn giản dựa trên tên đường dẫn. Trong trường hợp này, sử dụng các android:path hoặc của nó pathPattern hoặc pathPrefix để phân biệt mà activity hệ thống sẽ mở các đường dẫn URI khác nhau.

  <category>
 - Bao gồm các BROWSABLE. Nó được yêu cầu intenFilter có thể truy cập được từ trình duyệt web.
  
 - DEFAUL -> cho phép ứng dụng của bạn phản hồi lại implicit intent. Nếu ko, activity chỉ có thể được bắt đầu nếu implict intent là tên component app

- Đoạn XML sau đây cho thấy cách có thể chỉ định intenFilter trong Manifest để tạo deeplink. 

          <activity android:name=".MainActivity">
        <intent-filter>
            <action android:name="android.intent.action.MAIN"/>

            <category android:name="android.intent.category.LAUNCHER"/>
        </intent-filter>
        <intent-filter android:label="ahihi">
            <action android:name="android.intent.action.VIEW"/>

            <category android:name="android.intent.category.DEFAULT"/>
            <category android:name="android.intent.category.BROWSABLE"/>

            <data
                    android:host="www.ducnt.com"
                    android:pathPrefix="/open"
                    android:scheme="https"/>
        </intent-filter>
        <intent-filter android:label="hihi">
            <action android:name="android.intent.action.VIEW"/>

            <category android:name="android.intent.category.DEFAULT"/>
            <category android:name="android.intent.category.BROWSABLE"/>

            <data
                    android:host="www.123123.com"
                    android:pathPrefix="/openn"
                    android:scheme="https"/>
        </intent-filter>
      </activity>

### Deeplink với Navigation component 
- Tìm hiểu về Navigation Component : https://docs.google.com/document/d/1jkHGsQhrFOQ5zcIuGXdUJEiFyXUmiWlfZzgCmTi3Hkw/edit?usp=sharing
- Với navigation component thì việc này sẽ đơn giản hơn rất nhiều! Nó cho phép chúng ta có thể viết thẳng thông tin mapping giữa url và destination trực tiếp vào navigation graph.

- <deepLink> là tag mà chúng ta sẽ cần dùng để làm điều này. Mỗi một <deepLink> sẽ yêu cầu phải có 1 thuộc tính bắt buộc là app:uri.

- Ngoài việc match trực tiếp Uri thì nó còn hỗ trợ các tính năng sau đây:

- Uri mà không bao gồm giao thức sẽ được coi mặc định là http và https. Ví dụ như www.ducnt.com sẽ được coi là http://www.ducnt.com và https://www.ducnt.com

- Placeholder được viết dưới dạng {placeholder_name} sẽ khớp với 1 hay nhiều ký tự. String value của placeholder có thể mang giá trị của bundle argument với key là tên trùng tên của argument. Ví dụ: http://www.ducnt.com/x/{id} sẽ tương ứng với http://www.ducnt.com/x/4/.
- Wildcard .* có thể được dùng để match 0 hoặc nhiều ký tự.

- NavController sẽ tự động xử lý ACTION_VIEW intent và tìm deep link phù hợp.

      <activity
                  android:id="@+id/navigationActivity"
                  android:name="com.example.deeplink.Navigation"
                  android:label="Nav">

        <argument
                android:name="xx"
                android:defaultValue="hii"
                app:argType="string"/>

        <deepLink app:uri="www.navigation.com/open/?x={xx}" />
      </activity>
      
  -Read uri : đơn giản sử dụng arg như bt lấy từ bundle 
  - Manifest : 
  
                     <activity android:name=".Navigation">
                          <nav-graph android:value="@navigation/navigation"/>
                  </activity>
                  
  ### Dynamiclink với Fireb

      
  
