#SELECT b.id, b.title, p.`name`  FROM books b INNER JOIN publishers p ON b.publisher_id= p.id WHERE p.`name`LIKE "%TRE%";
#Đếm số sách của từng nhà xuất bản
#SELECT COUNT(b.id) AS quantity, p.`name` FROM books b RIGHT JOIN publishers p ON b.publisher_id = p.id GROUP BY p.`name`;
#Tìm nhà xuất bản có ít nhất 2 cuốn sách
#SELECT p.id, p.`name`, COUNT(b.id) AS quantity FROM publishers p INNER JOIN books b ON p.id= b.publisher_id GROUP BY p.id HAVING COUNT(b.id) >=2
#Tính giá trung bình sách của từng nhà xuất bản
#SELECT AVG(b.price) AS AvgPrice, p.`name` FROM books b Right JOIN publishers p ON b.publisher_id = p.id GROUP BY p.id;
#Tính tổng giá sách của từng nhà xuất bản
#SELECT sum(b.price) AS tong, p.`name`, p.id FROM books b RIght JOIN publishers p ON b.publisher_id = p.id GROUP BY p.id;
#Tìm nhà xuất bản có tổng giá sách trên 150.000
#SELECT p.id, p.`name`, SUM(b.price) AS tong FROM publishers p INNER JOIN books b ON p.id=b.publisher_id GROUP BY p.id Having SUM(b.price)>150000
#Tìm tác giả có ít nhất 2 cuốn sách
#SELECT b.author FROM books b GROUP BY b.author HAVING COUNT(b.id)>=2
#Câu 13. Tìm sách có giá cao nhất
#SELECT b.title, b.price FROM books b WHERE b.price >= ALL (SELECT MAX(b.price) FROM books b);
#Câu 14. Tìm nhà xuất bản có nhiều sách nhất
#SELECT p.id, p.`name`, COUNT(b.id) AS quantity FROM publishers p INNER JOIN books b ON p.id = b.publisher_id GROUP BY p.id, p.`name` HAVING COUNT(b.id) >=ALL(SELECT COUNT(*) FROM books b GROUP BY b.publisher_id)
#Câu 15. Tìm nhà xuất bản có giá sách trung bình cao nhất
#SELECT p.id, p.`name`, AVG(b.price) AS avgPriceBook FROM publishers p INNER JOIN books b ON p.id=b.publisher_id GROUP BY p.id, p.`name` HAVING AVG(b.price) >=ALL (SELECT AVG(b.price) FROM books b GROUP BY b.publisher_id);
#Câu 16. Tìm sách có giá cao hơn giá trung bình của tất cả sách
#SELECT b.id,b.title, b.price FROM books b WHERE b.price >= ALL(SELECT AVG(b.price) FROM books b);
#Câu 17. Tìm nhà xuất bản chưa có sách
#SELECT p.id, p.`name` FROM publishers p left JOIN books b ON p.id=b.publisher_id where b.id IS NULL GROUP BY p.id,p.`name`  
#Câu 18. Tìm các sách có giá cao hơn giá trung bình của chính nhà xuất bản đó(Chưa thuộc/ chưa biết làm)
#SELECT b.id,b.title,p.`name`,b.price FROM books b INNER JOIN publishers p ON b.publisher_id=p.id Where b.price >= (SELECT AVG(b2.price) FROM books b2 WHERE b2.publisher_id = b.publisher_id)
#Câu 19. Tìm nhà xuất bản có từ 2 sách trở lên và giá trung bình trên 80.000
#SELECT p.id, p.`name` FROM publishers p INNER JOIN books b ON p.id = b.publisher_id GROUP BY p.`name`,p.id HAVING COUNT(b.id)>=2 AND AVG(b.price)>80000
#Câu 20. Tìm nhà xuất bản có số sách nhiều hơn nhà xuất bản có ID = 1
#SELECT p.id, p.`name` FROM publishers p INNER JOIN books b ON b.publisher_id=p.id GROUP BY p.id,p.`name` HAVING COUNT(b.id) > (SELECT COUNT(*) FROM books b WHERE b.publisher_id=1)
#Câu 21. Tìm nhà xuất bản có số sách bằng số sách của nhà xuất bản ID = 2
#SELECT p.id, p.`name` FROM publishers p INNER JOIN books b ON b.publisher_id=p.id GROUP BY p.id,p.`name` HAVING COUNT(b.id) = (SELECT COUNT(*) FROM books b WHERE b.publisher_id=2)
#Câu 22. Đếm số sách theo từng tác giả, chỉ lấy tác giả có tên bắt đầu bằng N
#SELECT b.author, COUNT(*) AS quantity FROM books b WHERE b.author LIKE "N%" GROUP BY author;
#Câu 23. Tìm nhà xuất bản có sách đắt nhất trên 100.000
#SELECT p.id, p.`name`, b.title,Max(b.price) FROM publishers p INNER JOIN books b ON p.id=b.publisher_id GROUP BY p.`name`,p.id HAVING Max(b.price)>100000;
#SELECT p.id, p.`name`, b.title,b.price FROM publishers p INNER JOIN books b ON p.id=b.publisher_id WHERE b.price>100000 AND b.price=(SELECT MAX(price) FROM books WHERE publisher_id=p.id) 
#Câu 24. Thống kê số sách, tổng giá và giá trung bình của từng nhà xuất bản
#SELECT p.id,p.`name`, COALESCE((COUNT(b.id)),0) AS quantity,COALESCE(SUM(b.price),0) AS SumTotal, COALESCE(AVG(b.price),0) AS AvgTotal FROM publishers p Left JOIN books b ON  b.publisher_id=p.id GROUP BY p.id,p.`name`
#Câu 25. Thống kê các nhà xuất bản có ít nhất 2 sách, sắp xếp theo số sách giảm dần
#SELECT p.id, p.`name`, COALESCE((COUNT(b.id)),0) AS quantity FROM publishers p LEFT JOIN books b ON b.publisher_id=p.id GROUP BY p.id,p.`name` HAVING COUNT(b.id)>=2 ORDER BY quantity DESC
#Câu 27. Tìm nhà xuất bản có số sách nhiều nhất và giá trung bình trên 80.000
#SELECT p.id, p.`name`, count(b.id)FROM publishers p INNER JOIN books b ON p.id=b.publisher_id GROUP BY p.`name`,p.id HAVING COUNT(b.id) >= All(SELECT COUNT(b2.id) FROM books b2 GROUP BY b2.publisher_id) AND AVG(b.price)>80000





#Lam bai
#SELECT * FROM books
#INSERT INTO books(title,author,price,publisher_id) VALUE(?,?,?,?)

#findByPublisherAndAuthor(int publisherId, String authorKeyword)
#SELECT p.id AS publisherId,p.`name`,p.address,b.id AS bookId,b.title,b.author, b.price FROM publishers p INNER JOIN books b ON b.publisher_id=p.id WHERE p.id=2 AND b.author LIKE "%Ngu%"


