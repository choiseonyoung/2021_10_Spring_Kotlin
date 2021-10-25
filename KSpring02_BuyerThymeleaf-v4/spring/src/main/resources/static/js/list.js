    // 바닐라JS
    // document.addEventListener("DOMContentLoaded",function(){
    // })
// JQuery 사용할때
// $(document.ready(function(){   }))
// $(function(){

// })
$(()=>{
    // JQuery 코드 영역
    // $("table.buyer_list tr").click(function() {  }) // *권장X
    /*
        class 가 buyer_list 인 table 내( > )의
        tr 중에 한개가 클릭되면 함수를 실행하라
        data-id 값을 getter 하여
        alert 창에 표시하라
    */
    // $("table.buyer_list tr").on("click",function(){
    //    const id = $(this).data("id") // data-id 를 getter 하기
    //    location.href="/detail?userid=" + id
    // })

    // const tableClickHandler = () => {    } // *제이쿼리에서 쓰기는 좀 불편. 아래 2개 중 한개 쓰면 됨
    // const tableClickHandler = function() {   } // *좀 더 세련된 신버전.
    function tableClickHandler() {
        const cname = $(this).attr("class")
        const id = $(this).data("id")
        if(cname == "buyer_tr") {
//            location.href = "/buyer/detail?userid=" + id
              location.href =
        } else if (cname == "order_tr") {
            location.href = "/order/detail?seq=" + id
        }

    }
    $("table.buyer_list tr").on("click", tableClickHandler)
    $("table.order_list tr").on("click", tableClickHandler)

})