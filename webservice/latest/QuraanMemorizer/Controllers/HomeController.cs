using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using QuraanMemorizer.Models;
using QuraanMemorizer.DAL;

namespace QuraanMemorizer.Controllers
{
    public class HomeController : Controller
    {
        ApplicationDbContext db = new ApplicationDbContext();
        public ActionResult Index()
        {
            ViewBag.Title = "Home Page";
            //db.Member.ToList();
            return View();
        }
    }
}
