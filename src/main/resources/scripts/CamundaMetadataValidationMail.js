load('classpath:scripts/moment.js')
out=JSON.stringify({
    "personalizations": [
        {
            "to": [
                {
                    "email": "anton.lorvi@students.fhnw.ch",
                    "name": "Anton Lorvi"
                }
            ],
            "dynamic_template_data": {
                "submissionDate": moment(submissionDate).format("DD.MM.YYYY"),
                "requestID": requestID,
                "clientName": clientName,
                "yearEndDate": moment(yearEndDate).format("DD.MM.YYYY"),
                "emailAuditTeam": emailAuditTeam,
                "emailDataProvider": emailDataProvider,
                "productionSelection": productionSelection,
                "deliveryDate": moment(deliveryDate).format("DD.MM.YYYY"),
                "coveredPeriod": coveredPeriod,
                "analysisDate": moment(analysisDate).format("DD.MM.YYYY"),
                "comparativeDate": moment(comparativeDate).format("DD.MM.YYYY"),
                "closureOfAccounts": closureOfAccounts,
                "freeText": freeText
            }
        }
    ],
    "from": {
        "email": "noreply@johndoe.com",
        "name": "Abu the Ape"
    },
    "reply_to": {
        "email": "noreply@johndoe.com",
        "name": "Abu the Ape"
    },
    "template_id": "d-4f372698e05449dba7fbfb95361bd641"
});