const addressbtn = document.querySelector('#address-form')
const addressclose = document.querySelector('#address-close')

addressbtn.addEventListener("click", function () {
    document.querySelector('.address-form').style.display = "flex"
})

addressclose.addEventListener("click", function () {
    document.querySelector('.address-form').style.display = "none"
})

// -------------------------------slider------------------------------

const rightbtn = document.querySelector('.fa-chevron-right')
const leftbtn = document.querySelector('.fa-chevron-left')
let index = 0
const imgNumber = document.querySelectorAll('.slider-content-left-top img')

rightbtn.addEventListener("click", function () {
    index = index + 1
    if (index > imgNumber.length - 1) {
        index = 0
    }
    document.querySelector(".slider-content-left-top").style.right = index * 100 + "%"
})
leftbtn.addEventListener("click", function () {
    index = index - 1
    if (index < 0) {
        index = imgNumber.length - 1
    }
    document.querySelector(".slider-content-left-top").style.right = index * 100 + "%"
})

// ---------------------------------------------------------------------------

const imgNumberLi = document.querySelectorAll('.slider-content-left-bottom li')
imgNumberLi.forEach(function (image, index) {
    image.addEventListener("click", function () {
        removeactive()
        document.querySelector(".slider-content-left-top").style.right = index * 100 + "%"
        image.classList.add("active")
    })
})

function removeactive() {
    let imgactive = document.querySelector('.active')
    imgactive.classList.remove("active")
}

// --------------------------------slide chạy tự động---------------------------------------

function imgAuto() {
    index = index + 1
    if (index > imgNumber.length - 1) {
        index = 0
    }
    removeactive()
    document.querySelector(".slider-content-left-top").style.right = index * 100 + "%"
    imgNumberLi[index].classList.add("active")
}

setInterval(imgAuto, 5000)

// --------------------------------slide chạy tự động: săn sale mỗi ngày---------------------------------------

const rightbtnSecond = document.querySelector('.fa-chevron-right-second')
const leftbtntwoSecond = document.querySelector('.fa-chevron-left-second')
const imgNumberSecond = document.querySelectorAll('.slider-product-one-content-items')

rightbtnSecond.addEventListener("click", function () {
    index = index + 1
    if (index > imgNumberSecond.length - 1) {
        index = 0
    }
    document.querySelector(".slider-product-one-content-items-content").style.right = index * 100 + "%"
})
leftbtntwoSecond.addEventListener("click", function () {
    index = index - 1
    if (index < 0) {
        index = imgNumberSecond.length - 1
    }
    document.querySelector(".slider-product-one-content-items-content").style.right = index * 100 + "%"
})

// --------------------------------mở delivery.html---------------------------------------

document.getElementById("deliveryButton").addEventListener("click", function () {
    window.location.href = "delivery.html";
});
