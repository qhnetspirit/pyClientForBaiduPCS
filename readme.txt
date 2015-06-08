中文说明 (English readme is at the bottom)

这是一个百度云/百度网盘的Python客户端。主要的目的就是在Linux环境下（Windows下应该也可用，但没有仔细测试过）通过命令行来使用百度云盘的2TB的巨大空间。比如，你可以用在Raspberry Pi树莓派上。它提供文件列表、下载、上传、比较、向上同步、向下同步，等操作。

由于百度PCS API权限限制，程序只能存取百度云端/apps/bypy目录下面的文件和目录。

特征: 支持Unicode/中文；失败重试；递归上传/下载；目录比较; 哈希缓存。

界面是英文的，主要是因为这个是为了Raspberry Pi树莓派开发的。

程序依赖

重要：想要支持中文，你要把系统的区域编码设置为UTF-8。（参见：http://perlgeek.de/en/article/set-up-a-clean-utf8-environment)

重要：你需要安装Python Requests 库. 在 Debian / Ubuntu / Raspbian 环境下，只需执行如下命令一次：

sudo pip install requests
安装

git clone到任意目录。（为了运行方便，可以把bypy.py和bypygui.pyw拷贝至/usr/bin/目录）

运行

cd 到clone的目录，运行： ./bypy.py 可见命令行支持的全部命令和参数。

简单的图形界面： ./bypygui.pyw

要找多线程图形界面的，这个貌似不错：bcloud

基本操作

显示使用帮助和所有命令（英文）:

bypy.py
第一次运行时需要授权，只需跑任何一个命令（比如 bypy.py info）然后跟着说明（登陆等）来授权即可。授权只需一次，一旦成功，以后不会再出现授权提示.

更详细的了解某一个命令：

bypy.py help <command>
显示在云盘（程序的）根目录下文件列表：

bypy.py list
把当前目录同步到云盘：

bypy.py syncup
or

bypy.py upload
把云盘内容同步到本地来：

bypy.py syncdown
or

bypy.py downdir /
比较本地当前目录和云盘（程序的）根目录（个人认为非常有用）：

bypy.py compare
更多命令和详细解释请见运行bypy.py的输出。

调试

运行时添加-v参数，会显示进度详情。
运行时添加-d，会显示一些调试信息。
运行时添加-ddd，还会会显示HTTP通讯信息（警告：非常多）
经验分享

请移步至wiki，方便分享/交流。