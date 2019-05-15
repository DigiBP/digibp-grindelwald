load('classpath:scripts/moment.js')
out=JSON.stringify({
    "personalizations": [
        {
            "to": [
                {
                    "email": emailAuditTeam,
                    "name": "Audit Team"
                }
            ],
            "dynamic_template_data": {
                "submissionDate": moment(submissionDate).format("DD.MM.YYYY"),
                "requestID": requestID,
                "nameDataProvider": nameDataProvider,
                "emailDataProvider": emailDataProvider,
                "emailAuditTeam": emailAuditTeam,
                "clientID":clientID,
                "productionSelection": productionSelection,

            }
        }
    ],
    "from": {
        "email": "noreply.bananaanalytics.com",
        "name": "Abu the Ape"
    },
    "reply_to": {
        "email": "noreply.bananaanalytics.com",
        "name": "Abu the Ape"
    },
    "template_id": "d-ca56e522541240059bc97b6d8ca41f9c"
});