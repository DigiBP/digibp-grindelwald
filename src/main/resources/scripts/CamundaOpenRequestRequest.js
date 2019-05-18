load('classpath:scripts/moment.js')
out = JSON.stringify({
    "requestID": requestID,
    "clientID": clientID,
    "yearEndDate": moment(yearEndDate).format("DD-MM-YYYY"),
    "emailAuditTeam": emailAuditTeam,
    "nameDataProvider": nameDataProvider,
    "emailDataProvider": emailDataProvider,
    "productSelection": productSelection,
    "deliveryDate": moment(deliveryDate).format("DD-MM-YYYY"),
    "coveredPeriod": coveredPeriod,
    "analysisDate": moment(analysisDate).format("DD-MM-YYYY"),
    "comparativeDate": moment(comparativeDate).format("DD-MM-YYYY"),
    "closureOfAccounts": closureOfAccounts,
    "freeText": freeText
});