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
                "metadataFolderShareLink": metadataFolderShareLink
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
    "template_id": "d-4f372698e05449dba7fbfb95361bd641"
});