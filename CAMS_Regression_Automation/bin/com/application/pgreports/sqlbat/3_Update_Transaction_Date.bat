sqlcmd -Q " UPDATE  B SET B.TD_DTRAN_DATE_TIME=Tran_date_time, B.TD_SBUSINESS_DATE=Tran_date FROM STAGING_TRANSACTION_DETAILS A WITH  (NOLOCK) INNER JOIN PG_TRANSACTION_DETAILS B WITH (NOLOCK) ON A.Tran_message_id=B.TD_STRAN_MESSAGE_ID " -S "10.10.10.205" -U "sa" -P "sqlserver@1" -d "VegaaHAutomation"
