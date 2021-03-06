function gcd(a,b) {
    if (a < 0) a = -a;
    if (b < 0) b = -b;
    if (b > a) {var temp = a; a = b; b = temp;}
    while (true) {
        a %= b;
        if (a == 0) return b;
        b %= a;
        if (b == 0) return a;
    }
}

function encode(msg, rot) {
    return msg.replace(/([a-z])/ig,
        function($1) {
            var c = $1.charCodeAt(0);
            return String.fromCharCode(
                c >= 97 ? (c + rot + 26 - 97) % 26 + 97
                    : (c + rot + 26 - 65) % 26 + 65);
        });
}

function lcs(x,y){
    var s,i,j,m,n,
        lcs=[],row=[],c=[],
        left,diag,latch;
    //make sure shorter string is the column string
    if(m<n){s=x;x=y;y=s;}
    m = x.length;
    n = y.length;
    //build the c-table
    for(j=0;j<n;row[j++]=0);
    for(i=0;i<m;i++){
        c[i] = row = row.slice();
        for(diag=0,j=0;j<n;j++,diag=latch){
            latch=row[j];
            if(x[i] == y[j]){row[j] = diag+1;}
            else{
                left = row[j-1]||0;
                if(left>row[j]){row[j] = left;}
            }
        }
    }
    i--,j--;
    //row[j] now contains the length of the lcs
    //recover the lcs from the table
    while(i>-1&&j>-1){
        switch(c[i][j]){
            default: j--;
                lcs.unshift(x[i]);
            case (i&&c[i-1][j]): i--;
                continue;
            case (j&&c[i][j-1]): j--;
        }
    }
    return lcs.join('');
}