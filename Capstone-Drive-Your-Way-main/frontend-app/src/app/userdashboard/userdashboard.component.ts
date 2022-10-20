import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit {
  flagos:boolean = false;

  user:string ="";
  products:Array<Product>=[];
  constructor(public router:Router,public ps:ProductService) { }

  ngOnInit(): void {
    this.findAllProduct();
    let obj = sessionStorage.getItem("userDetails");
    if(obj!=null){
      this.user=obj;
    }
  }


  logout() {
    sessionStorage.removeItem("userDetails");
    this.router.navigate(["login"]);
  }


 flago(){
  this.flagos=true;

 }

  flag:boolean = false;
  pid:number =0;
  price:number =0;
  url:string ="";
  findAllProduct() {
    this.ps.findAllProduct().subscribe({
      next:(result:any)=>this.products=result,
      error:(error:any)=>console.log(error),
      complete:()=>console.log("completed")
    })
  }

  deleteProduct(pid:number){
    //console.log(pid)
    this.ps.deleteProductById(pid).subscribe({
      next:(result:any)=>console.log(result),
      error:(error:any)=>console.log(error),
      complete:()=>{
          this.findAllProduct();   
      }
    })
  }

  updateProduct(product:any){
      this.flag= true;
      this.pid=product.pid;
      this.price=product.price;
      this.url=product.url;
  }

  updateDataFromDb(){
    let product = {pid:this.pid,price:this.price,url:this.url};
    this.ps.updateProduct(product).subscribe({
      next:(result:any)=>console.log(result),
      error:(error:any)=>console.log(error),
      complete:()=>{
          this.findAllProduct();   
      }
    })
    this.flag=false;
  }
}
