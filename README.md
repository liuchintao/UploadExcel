# UploadExcel
This project is a maven project using SSM framework and POI to upload excel to MySQL database.
本项目使用SSM框架，利用Apache提供的POI处理从前端得到的EXCEL文件。
设计思路：１）@RequestParam标签在Controller中获得前端的name="xlsfile"的MultipartFile；2）利用HSSFWorkbook（2003版office及之前版本）或XSSFWorkbook（2007版本之后office）得到Wookbook对象，取出数据并封装进Entity实例中并添加进List<T>；3）利用Mybatis进行数据库操作。
