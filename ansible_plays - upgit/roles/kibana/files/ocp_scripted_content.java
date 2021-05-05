def msg= doc['message'];\ndef fieldArr = msg.toString().splitOnToken('|');\n\ndef extMsg="";\nMap fieldMap = new HashMap();
fieldMap.put(0,'time');
fieldMap.put(1,'billingNumber');
fieldMap.put(2,'timestamp');
fieldMap.put(3,'service');
fieldMap.put(4,'sessionID');
fieldMap.put(5,'requestType');
for (int i = 0; i < fieldArr.length; i++) {
    if(i<fieldMap.size())
        extMsg=extMsg+fieldMap.get(i)+'='+fieldArr[i]+'|';
    else
        extMsg=extMsg+fieldArr[i]+'|';
}
try {
    return extMsg;
} catch (Exception ex){
    return extMsg+'\nException:: ' + ex.toString();
}
