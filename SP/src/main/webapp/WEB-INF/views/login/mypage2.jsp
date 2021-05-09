<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<jsp:include page="/WEB-INF/views/include/setting.jsp"></jsp:include>
<link
	href="${pageContext.request.contextPath}/resources/assets/css/fullcalendar.css"
	rel='stylesheet' />
<link
	href="${pageContext.request.contextPath}/resources/assets/css/fullcalendar.print.css"
	rel='stylesheet' media='print' />
<script
	src="${pageContext.request.contextPath}/resources/assets/js/jquery-1.10.2.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/assets/js/jquery-ui.custom.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/assets/js/fullcalendar.js"
	type="text/javascript"></script>
<script>
   $(document).ready(function() {
      /* var calendarList = ${ calendarVOList }; */
      
       var date = new Date();
      var d = date.getDate();
      var m = date.getMonth();
      var y = date.getFullYear();

      /*  className colors

      className: default(transparent), important(red), chill(pink), success(green), info(blue)

      */


      /* initialize the external events
      -----------------------------------------------------------------*/

      $('#external-events div.external-event').each(function() {

         // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
         // it doesn't need to have a start or end
         var eventObject = {
            title: $.trim($(this).text()) // use the element's text as the event title
         };

         // store the Event Object in the DOM element so we can get to it later
         $(this).data('eventObject', eventObject);

         // make the event draggable using jQuery UI
         $(this).draggable({
            zIndex: 999,
            revert: true,      // will cause the event to go back to its
            revertDuration: 0  //  original position after the drag
         });

      });


      /* initialize the calendar
      -----------------------------------------------------------------*/

      var calendar =  $('#calendar').fullCalendar({
         header: {
            left: 'title',
            center: 'agendaDay,agendaWeek,month',
            right: 'prev,next today'
         },
         editable: true,
         firstDay: 1, //  1(Monday) this can be changed to 0(Sunday) for the USA system
         selectable: true,
         defaultView: 'month',

         axisFormat: 'h:mm',
         columnFormat: {
                month: 'ddd',    // Mon
                week: 'ddd d', // Mon 7
                day: 'dddd M/d',  // Monday 9/7
                agendaDay: 'dddd d'
            },
            titleFormat: {
                month: 'MMMM yyyy', // September 2009
                week: "MMMM yyyy", // September 2009
                day: 'MMMM yyyy'                  // Tuesday, Sep 8, 2009
            },
         allDaySlot: false,
         selectHelper: true,
         select: function(start, end, allDay) {
            var title = prompt('메모하세요:');
            if (title) {
               var startyear = start.getFullYear().toString();
               var startmonth = (start.getMonth() + 1).toString();
               var startday = start.getDate().toString();
               var start = startyear + "-" + startmonth + "-" + startday;
               var endyear = end.getFullYear().toString();
               var endmonth = (end.getMonth() + 1).toString();
               var endday = end.getDate().toString();
               var end = endyear + "-" + endmonth + "-" + endday;
               var vo = {
                     title: title,
                     start: start,
                     end: end
                  }
               // ajax 통신으로 controller접근해서 디비 저장 
               $.ajax({
                  type:"POST",
                  url:"${pageContext.request.contextPath}/calendar",
                  data:vo,
                  dataType:"JSON",
                  success: function(data){
                     if(data == 1) {
                        alert("등록성공");
                        setTimeout("location.href='${pageContext.request.contextPath}/mypage2'", 20);
                     } else alert("실패");
                  }
               });

            }
            calendar.fullCalendar('unselect');
         },
         droppable: true, // this allows things to be dropped onto the calendar !!!
         drop: function(date, allDay) { // this function is called when something is dropped

            // retrieve the dropped element's stored Event Object
            var originalEventObject = $(this).data('eventObject');

            // we need to copy it, so that multiple events don't have a reference to the same object
            var copiedEventObject = $.extend({}, originalEventObject);

            // assign it the date that was reported
            copiedEventObject.start = date;
            copiedEventObject.allDay = allDay;

            // render the event on the calendar
            // the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
            $('#calendar').fullCalendar('renderEvent', copiedEventObject, true);

            // is the "remove after drop" checkbox checked?
            if ($('#drop-remove').is(':checked')) {
               // if so, remove the element from the "Draggable Events" list
               $(this).remove();
            }

         },

         events: [ ${calendarList}]
            });


   });

</script>
<style type="text/css">
#sidemenu>ul>li>a {
	text-decoration: none;
	display: block;
}

#sidemenu {
	width: 200px;
	float: left;
	padding-right: 40px;
}

#wrap {
	width: 1200px;
	margin: 0 auto;
}

#external-events {
	float: right;
	width: 150px;
	margin-left: 20px;
	padding: 0 10px;
	border: 1px solid #ccc;
	background: #eee;
	text-align: left;
}

#external-events h4 {
	font-size: 16px;
	margin-top: 0;
	padding-top: 1em;
}

#external-events .fc-event {
	margin: 10px 0;
	cursor: pointer;
}

#external-events p {
	margin: 1.5em 0;
	font-size: 11px;
	color: #666;
}

#external-events p input {
	margin: 0;
	vertical-align: middle;
}

#calendar {
	float: left;
	margin: 0 auto;
	width: 800px;
	background-color: #FFFFFF;
	border-radius: 6px;
	box-shadow: 0 1px 2px #C3C3C3;
	height: inherit;
}
</style>

<title>마이페이지</title>
</head>
<body class="subpage">

	<header>
		<jsp:include page="/WEB-INF/views/include/top.jsp" />
	</header>

	<!-- Main -->
	<section id="main" class="wrapper">
		<div class="inner">
			<div class="row">
				<div class="2u 12u$">
					<aside id="sidemenu">
						<ul class="alt">
							<li><a href="${pageContext.request.contextPath}/myinfo" style="color: gray;">회원
									정보</a></li>
							<li><a href="${pageContext.request.contextPath}/mypage/${loginSucessVO.id}" style="color: gray;">복용
									약 목록</a></li>
							<li><a href="${pageContext.request.contextPath}/mypage2">My
									Calendar</a></li>

						</ul>

					</aside>
					<!-- <div id='external-events'>
							<h4>내 알약리스트</h4>

							<div id='external-events-list'>
								<div class='fc-event'>My Event 1</div>
								<div class='fc-event'>My Event 2</div>
								<div class='fc-event'>My Event 3</div>
								<div class='fc-event'>My Event 4</div>
								<div class='fc-event'>My Event 5</div>
							</div>

						</div> -->
				</div>
				<div class="10u 12u$">
					<div id='wrap'>

						<div id='calendar'></div>

						<div style='clear: both'></div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<br>
	<br>
	<br>
	<!-- Footer -->
	<footer>
		<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</footer>

</body>
</html>
