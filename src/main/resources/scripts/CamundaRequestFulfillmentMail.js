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
                "datacubeFolderShareLink": datacubeFolderShareLink
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
    "template_id": "d-6cf1059ee8b74a529ea23440ff4b9c53"
});

https://secure.sharefile.com/oauth/index.aspx?redirect_uri=https://www.integromat.com/oauth/cb/oauth2
https://secure.sharefile.com/oauth/token?grant_type=authorization_code