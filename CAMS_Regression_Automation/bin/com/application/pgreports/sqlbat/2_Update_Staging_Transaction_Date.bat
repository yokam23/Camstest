sqlcmd -Q " UPDATE  A SET A.Tran_date_time=DATEADD(DD,DATEDIFF(DD,Tran_date_time,Tran_date),Tran_date_time) FROM STAGING_TRANSACTION_DETAILS A WITH  (NOLOCK) INNER JOIN PG_TRANSACTION_DETAILS B WITH (NOLOCK) ON A.Tran_message_id=B.TD_STRAN_MESSAGE_ID " -S "10.10.10.205" -U "sa" -P "sqlserver@1" -d "VegaaHAutomation"
