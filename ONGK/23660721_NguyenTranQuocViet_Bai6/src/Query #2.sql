/*Lấy danh sách tất cả tin tức kèm theo tên danh mục tương ứng*/
#SELECT t.MATT,t.NOIDUNGTT,d.TENDANHMUC FROM tintuc t INNER JOIN danhmuc d On t.MADM=d.MADM;
/*Lấy danh sách tin tức thuộc về một danh mục cụ thể (Ví dụ: "Thời sự")*/
#SELECT t.MATT ,t.TIEUDE, t.NOIDUNGTT, d.TENDANHMUC FROM tintuc t INNER JOIN danhmuc d ON t.MADM = d.MADM where d.TENDANHMUC="Thời sự";
/*Thống kê số lượng bài viết tin tức có trong mỗi danh mục*/
#SELECT COUNT(t.MATT) AS soluong, d.TENDANHMUC  FROM tintuc t Inner JOIN danhmuc d ON t.MADM=d.MADM GROUP BY (d.TENDANHMUC	);
/*Liệt kê các danh mục có từ 3 bài viết tin tức trở lên*/
#SELECT d.MADM, d.TENDANHMUC FROM danhmuc d INNER JOIN tintuc t ON d.MADM=t.MADM GROUP BY d.TENDANHMUC Having COUNT(t.MATT)>=3;
/*Tìm danh mục có số lượng bài viết tin tức nhiều nhất*/
#SELECT m.MADM, t.TIEUDE, COUNT(t.MATT) AS SoTinTuc FROM danhmuc m INNER JOIN tintuc t ON m.MADM = t.MADM GROUP BY m.MADM HAVING COUNT(t.MATT) >= ALL(SELECT COUNT(*) FROM tintuc GROUP BY MADM);
