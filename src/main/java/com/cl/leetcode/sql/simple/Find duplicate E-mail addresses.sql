# {"headers": {"Person": ["Id", "Email"]}, "rows": {"Person": [[1, "a@b.com"], [2, "c@d.com"], [3, "a@b.com"]]}}

USE leetcode;

SELECT data_.Email
FROM (SELECT
        Email,
        count(id) num
      FROM person
      GROUP BY Email) data_  WHERE data_.num > 1;


## 优化
select Email
from Person
group by Email
having count(Email) > 1