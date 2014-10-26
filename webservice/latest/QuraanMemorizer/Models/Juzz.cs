using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace QuraanMemorizer.Models
{
    public class Juzz
    {
        [DatabaseGenerated(DatabaseGeneratedOption.None)] 
        public int JuzzId { get; set; }
        public string JuzzName { get; set; }       

    }
}