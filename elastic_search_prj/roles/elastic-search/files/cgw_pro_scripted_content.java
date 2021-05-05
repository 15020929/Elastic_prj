def msg=doc['filter__key_name'];
def fieldArr = msg.toString().splitOnToken((String)(char)0x0a);
def recoverMsg="";
def avpKey=0;
def avpVal="";
Map fieldMap = new HashMap();
fieldMap.put('1','|interfaceId');
fieldMap.put('2','|isRequest');
….
fieldMap.put('30000','|Session-Release-Cause');
fieldMap.put('30001','|useMCCMNC');
for (int i = 0; i < fieldArr.length; i++) {
    avpKey=fieldArr[i].splitOnToken('=')[0];
    if(fieldArr[i].splitOnToken('=').length == 2)
        if(fieldMap.get(avpKey.trim()) != null)
            recoverMsg=recoverMsg+avpKey+fieldMap.get(avpKey.trim())+'='+fieldArr[i].splitOnToken('=')[1]+(String)(char)0x0a;
        else
            recoverMsg=recoverMsg+avpKey+'='+fieldArr[i].splitOnToken('=')[1]+(String)(char)0x0a;
    else if(fieldArr[i].splitOnToken('=').length == 1)
        if(fieldMap.get(avpKey.trim()) != null)
            recoverMsg=recoverMsg+avpKey+fieldMap.get(avpKey.trim())+(String)(char)0x0a;
        else
        recoverMsg=recoverMsg+avpKey+(String)(char)0x0a;
    else
        recoverMsg=recoverMsg+fieldArr[i]+(String)(char)0x0a;
} try {
    return recoverMsg;
} catch (Exception ex){
    return msg+"\\nException:: " + ex.toString();
}