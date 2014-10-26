using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace QuraanMemorizer.Models
{
    public class QuraanAudio
    {
        public int Id { get; set; }
        public int ReciterId { get; set; }
        public string AudioName { get; set; }
        public  Reciter Reciter { get; set; }

    }
}