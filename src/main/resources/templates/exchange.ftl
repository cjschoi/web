<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>거래소</title>
</head>
<script src="/lib/Vue.js"></script>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.16.2/axios.min.js"></script>

<body>

    <div id="trading-info">
        <table>
            <tr>
                <td>비트코인</td><td>BTC/KRW</td>
            </tr>
            <tr>
                <td>
                    <tr>
                        <td>{{List.base_volume}}</td><td>KRW</td>
                    </tr>
                    <tr>
                        <td>전일대비</td>&nbsp;<td>+7.94</td>&nbsp;<td>1,859,000</td>
                    </tr>
                </td>
                <td>
                    <tr>
                        <td>고가</td><td>26,090,000</td><td>거래량(24H)</td><td>54,094,740</td><td>BTC</td>
                    </tr>
                    <tr>
                        <td>저가</td><td>22,338,000</td><td>거래대금(24H)</td><td>1,254,094,740</td><td>KRW</td>
                    </tr>
                </td>
            </tr>
        </table>
    </div>


    <div id="app1">
        <button v-on:click="getMessage">데이터 변경</button>
    </div>

</body>


<script src="/exchange.js"></script>
</html>