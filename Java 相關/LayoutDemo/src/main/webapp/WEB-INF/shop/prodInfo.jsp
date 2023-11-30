<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<button id="openModal" type="button" class="btn btn-primary mx-auto my-3 d-block" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
  Show Product ${info}
</button>

 <!-- Modal -->
 <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
   <div class="modal-dialog">
    <div class="modal-content">
     <div class="modal-header">
       <h5 class="modal-title" id="staticBackdropLabel">${info} , ${price} </h5>
       <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
     </div>
     <div class="modal-body">
       <img src="${img}" class="card-img-top" alt="...">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Understood</button>
      </div>
    </div>
  </div>
</div>

<%@ include file="/WEB-INF/view/library.jspf" %>