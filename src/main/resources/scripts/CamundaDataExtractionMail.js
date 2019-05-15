load('classpath:scripts/moment.js')
out=JSON.stringify({
    "personalizations": [
        {
            "to": [
                {
                    "email": emailDataProvider,
                    "name": "nameDataProvider"
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
                "yearEndDate": moment(yearEndDate).format("DD.MM.YYYY"),
                "deliveryDate": moment(deliveryDate).format("DD.MM.YYYY"),
                "analysisDate": moment(analysisDate).format("DD.MM.YYYY"),
                "comparativeDate": moment(comparativeDate).format("DD.MM.YYYY"),
                "closureOfAccounts": moment(closureOfAccounts).format("DD.MM.YYYY"),
                "coveredPeriod": coveredPeriod,
                "freeText": freeText,
                "requestFolderShareLink": requestFolderShareLink
            }
        }
    ],
    "from": {
        "email": "noreply@bananaanalytics.com",
        "name": "Abu the Ape"
    },
    "reply_to": {
        "email": "noreply@bananaanalytics.com",
        "name": "Abu the Ape"
    },
    "template_id": "d-ca56e522541240059bc97b6d8ca41f9c"
});