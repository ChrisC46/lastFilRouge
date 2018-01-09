/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var activeinput

            function populateTd() {
                var tdcollection = document.getElementsByTagName('table')[0].getElementsByTagName('td')
                for (i = 0; i < tdcollection.length; i++) {
                    tdcollection[i].className = 'up'
                    tdcollection[i].onmousedown = function () {
                        this.className = 'down'
                    }
                    tdcollection[i].onmouseup = function () {
                        this.className = 'up'
                    }
                    tdcollection[i].onclick = function () {
                        if (!!activeinput) {
                            activeinput.value += this.innerHTML
                        }
                    }
                }
            }