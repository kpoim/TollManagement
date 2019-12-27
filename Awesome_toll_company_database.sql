create trigger copy_history
before insert 
on ongoing_logs
for each row
BEGIN
	insert into history_logs 
    set 
    cardid = new.cardid,
    entrytime = new.entrytime,
    entrygateid = new.entrygateid;
END;
$
DELIMITER ;

