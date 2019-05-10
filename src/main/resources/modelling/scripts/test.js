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
                "submissionDate": submissionDate.toString().split('T')[0],
                "requestID": requestID,
                "clientName": clientName,
                "yearEndDate": yearEndDate.toString().split('T')[0],
                "emailAuditTeam": emailAuditTeam,
                "emailDataProvider": emailDataProvider,
                "productionSelection": productionSelection,
                "deliveryDate": deliveryDate,
                "coveredPeriod": coveredPeriod,
                "analysisDate": analysisDate,
                "comparativeDate": comparativeDate,
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
    "template_id": "d-3ffde2a6cf534d2ab6332bbbbf4cb24f"
});