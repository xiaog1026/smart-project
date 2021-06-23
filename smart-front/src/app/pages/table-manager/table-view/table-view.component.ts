import { Component, OnInit } from '@angular/core';
import { TableMasterVO } from 'app/model/table.master.vo';
import { TableService } from 'app/services/table.service';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-table-view',
  templateUrl: './table-view.component.html',
  styleUrls: ['./table-view.component.scss']
})

export class TableViewComponent implements OnInit {
  upComing: any[] = [];

  searchStr = '';
  option = 'option1';
  modalRef: NgbModalRef;
  tableMasterList: TableMasterVO[];
  tableMaster : TableMasterVO = new TableMasterVO(); 

  constructor(private modal: NgbModal ,private tableService: TableService,private router : Router) { }

  ngOnInit() {
    this.search();
  }


  search() {
    const searchParameter = {
      queryOption : this.option,
      keyWord : this.searchStr
    };
    console.log('searchParameter', searchParameter);

    this.tableService.searchTables(searchParameter).subscribe(resData => {
      this.tableMasterList = resData.result;
      console.log('tableMasterList', this.tableMasterList);
    });
  }

  toRegister(popup1:any) {
    this.modalRef = this.modal.open(popup1,{size:'lg'})
  }
  toModify(tableId:number,popup2:any){
    this.modalRef = this.modal.open(popup2,{size:'lg'})
    this.tableService.searchTable(tableId).subscribe(resData =>{
      this.tableMaster = resData.result;
    });
  }

  close(){
    this.modalRef.close();
    this.search;
  }
  registerTable(){
    console.log(this.tableMaster);
    this.tableService.registerTable(this.tableMaster).subscribe(() =>{
      this.modalRef.close();
      this.search();
    });
  }
  modifyTable(){
    console.log(this.tableMaster);
    this.tableService.modifyTable(this.tableMaster).subscribe(() =>{
      this.modalRef.close();
      this.search();
    });
  }
}
