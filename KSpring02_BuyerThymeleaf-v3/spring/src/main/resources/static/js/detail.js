$(function(){
    const button = $("section.buyer_detail button")
    if(button) {
        $(button).on("click",function(){
            const className = $(this).attr("class")
            let href = `${rootPath}buyer`
            if(className.includes("btn_update")) {
//                alert(`Update ${userid}`)
                href=`${href}/update/${userid}`
            } else if(className.includes("btn_delete")) {
//                alert(`delete ${userid}`)
//                if(confirm("삭제할까요?")) {
//                    href=`${href}/delete/${userid}`
//                } else {
//                    return false;
//                }
                href=`${href}/delete/${userid}`
                if(!confirm("삭제할까요?")) {
                    return false;
                }

            }
            location.href = `${href}`
        })

    }
})