using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace QuraanMemorizer.Models
{
    public class Surrah
    {  
        [DatabaseGenerated(DatabaseGeneratedOption.None)]
        public int Id { get; set; }
        public string SurrahName { get; set; }
        public int TotalNoOfAyaat { get; set; } 

    }
}